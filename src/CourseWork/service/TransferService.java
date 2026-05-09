package CourseWork.service;

import CourseWork.exception.InvalidTransferException;
import CourseWork.model.Account;
import CourseWork.model.ReportRecord;
import CourseWork.model.TransferRequest;
import CourseWork.repository.AccountRepository;
import CourseWork.repository.ReportRepository;
import CourseWork.util.AccountValidator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Stream;

public class TransferService {
    private static final DateTimeFormatter ARCHIVE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private final AccountRepository accountRepository;
    private final ReportRepository reportRepository;
    private final TransferParser transferParser;

    public TransferService(AccountRepository accountRepository, ReportRepository reportRepository, TransferParser transferParser) {
        this.accountRepository = accountRepository;
        this.reportRepository = reportRepository;
        this.transferParser = transferParser;
    }

    /**
     * Обрабатывает все txt-файлы из папки input и переносит их в архив.
     */
    public void processInputDirectory(Path inputDirectory, Path archiveDirectory) {
        try {
            Files.createDirectories(inputDirectory);
            Files.createDirectories(archiveDirectory);
        } catch (IOException e) {
            System.out.println("Cannot prepare input or archive directory: " + e.getMessage());
            return;
        }

        try (Stream<Path> files = Files.list(inputDirectory)) {
            long processedCount = files
                    .filter(Files::isRegularFile)
                    .filter(this::isTxtFile)
                    .map(file -> processFile(file, archiveDirectory))
                    .filter(Boolean::booleanValue)
                    .count();

            if (processedCount == 0) {
                System.out.println("No txt files were found in input directory.");
            } else {
                System.out.println("Processed txt files: " + processedCount);
            }
        } catch (IOException e) {
            System.out.println("Cannot read input directory: " + e.getMessage());
        }
    }

    /**
     * Обрабатывает один файл перевода, записывает результат в отчет и архивирует файл.
     */
    private boolean processFile(Path file, Path archiveDirectory) {
        TransferRequest request = null;
        String status;

        try {
            request = transferParser.parse(new String(Files.readAllBytes(file), StandardCharsets.UTF_8));
            executeTransfer(request);
            status = "successfully processed";
        } catch (InvalidTransferException e) {
            status = "processing error, " + e.getMessage();
        } catch (IOException e) {
            status = "processing error, " + e.getMessage();
        }

        writeReport(file, request, status);
        moveToArchive(file, archiveDirectory);
        return true;
    }

    /**
     * Проверяет перевод, изменяет балансы счетов и сохраняет обновленный файл счетов.
     */
    private void executeTransfer(TransferRequest request) throws IOException, InvalidTransferException {
        validateRequest(request);

        Map<String, Account> accounts = accountRepository.findAll();
        Account from = accounts.get(request.getFromAccount());
        Account to = accounts.get(request.getToAccount());

        if (from == null) {
            throw new InvalidTransferException("source account was not found");
        }
        if (to == null) {
            throw new InvalidTransferException("target account was not found");
        }
        if (from.getBalance().compareTo(request.getAmount()) < 0) {
            throw new InvalidTransferException("not enough money on source account");
        }

        from.withdraw(request.getAmount());
        to.deposit(request.getAmount());
        accountRepository.saveAll(accounts);
    }

    /**
     * Проверяет базовые правила перевода до изменения балансов.
     */
    private void validateRequest(TransferRequest request) throws InvalidTransferException {
        if (!AccountValidator.isValidAccountNumber(request.getFromAccount())) {
            throw new InvalidTransferException("invalid source account number");
        }
        if (!AccountValidator.isValidAccountNumber(request.getToAccount())) {
            throw new InvalidTransferException("invalid target account number");
        }
        if (request.getFromAccount().equals(request.getToAccount())) {
            throw new InvalidTransferException("source and target accounts are the same");
        }
        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransferException("invalid transfer amount");
        }
    }

    /**
     * Записывает успешный или ошибочный результат обработки файла в отчет.
     */
    private void writeReport(Path file, TransferRequest request, String status) {
        String operation = request == null
                ? "transfer data was not parsed"
                : request.toReportText();

        try {
            reportRepository.append(new ReportRecord(LocalDateTime.now(), file.getFileName().toString(), operation, status));
        } catch (IOException e) {
            System.out.println("Cannot write report record for " + file.getFileName() + ": " + e.getMessage());
        }
    }

    /**
     * Переносит обработанный файл в архив и добавляет timestamp, если имя уже занято.
     */
    private void moveToArchive(Path file, Path archiveDirectory) {
        try {
            Path destination = archiveDirectory.resolve(file.getFileName());
            if (Files.exists(destination)) {
                String fileName = file.getFileName().toString();
                destination = archiveDirectory.resolve(ARCHIVE_TIME_FORMATTER.format(LocalDateTime.now()) + "_" + fileName);
            }

            Files.move(file, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Cannot move file to archive: " + file.getFileName() + ". " + e.getMessage());
        }
    }

    /**
     * Проверяет, что файл имеет расширение .txt.
     */
    private boolean isTxtFile(Path file) {
        return file.getFileName().toString().toLowerCase().endsWith(".txt");
    }
}
