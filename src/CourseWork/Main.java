package CourseWork;

import CourseWork.repository.AccountRepository;
import CourseWork.repository.ReportRepository;
import CourseWork.service.ReportService;
import CourseWork.service.TransferParser;
import CourseWork.service.TransferService;
import CourseWork.util.AppPaths;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppPaths.createRequiredDirectories();

        AccountRepository accountRepository = new AccountRepository(AppPaths.ACCOUNTS_FILE);
        ReportRepository reportRepository = new ReportRepository(AppPaths.REPORT_FILE);
        TransferParser transferParser = new TransferParser();
        TransferService transferService = new TransferService(accountRepository, reportRepository, transferParser);
        ReportService reportService = new ReportService(reportRepository);

        try {
            accountRepository.createFileWithDefaultAccountsIfMissing();
        } catch (IOException e) {
            System.out.println("Cannot prepare accounts file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    transferService.processInputDirectory(AppPaths.INPUT_DIRECTORY, AppPaths.ARCHIVE_DIRECTORY);
                    break;
                case "2":
                    reportService.printAllOperations();
                    break;
                case "3":
                    printOperationsByDates(scanner, reportService);
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Unknown command. Please enter 1, 2, 3 or 0.");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1 - parse transfer files from input directory");
        System.out.println("2 - show all operations from report");
        System.out.println("3 - show operations by date range");
        System.out.println("0 - exit");
        System.out.print("Choose action: ");
    }


    private static void printOperationsByDates(Scanner scanner, ReportService reportService) {
        try {
            System.out.print("Date from (yyyy-MM-dd): ");
            LocalDate from = LocalDate.parse(scanner.nextLine().trim());
            System.out.print("Date to (yyyy-MM-dd): ");
            LocalDate to = LocalDate.parse(scanner.nextLine().trim());
            reportService.printOperationsByDates(from, to);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Use yyyy-MM-dd.");
        }
    }
}
