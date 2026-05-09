package CourseWork.service;

import CourseWork.model.ReportRecord;
import CourseWork.repository.ReportRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    /**
     * Выводит все операции из файла-отчета.
     */
    public void printAllOperations() {
        try {
            printLines(reportRepository.findAllLines());
        } catch (IOException e) {
            System.out.println("Cannot read report file: " + e.getMessage());
        }
    }

    /**
     * Выводит операции, дата которых попадает в указанный диапазон.
     */
    public void printOperationsByDates(LocalDate from, LocalDate to) {
        if (from.isAfter(to)) {
            System.out.println("Date from cannot be after date to.");
            return;
        }

        try {
            List<String> lines = reportRepository.findAllLines();
            boolean found = false;

            for (String line : lines) {
                LocalDateTime operationDateTime = parseDateTime(line);
                if (operationDateTime == null) {
                    continue;
                }

                LocalDate operationDate = operationDateTime.toLocalDate();
                if (!operationDate.isBefore(from) && !operationDate.isAfter(to)) {
                    System.out.println(line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No report records were found for selected dates.");
            }
        } catch (IOException e) {
            System.out.println("Cannot read report file: " + e.getMessage());
        }
    }


    private void printLines(List<String> lines) {
        if (lines.isEmpty()) {
            System.out.println("Report file is empty or missing.");
            return;
        }

        for (String line : lines) {
            System.out.println(line);
        }
    }

    /**
     * Достает дату и время из первой части строки отчета.
     */
    private LocalDateTime parseDateTime(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 0) {
            return null;
        }

        try {
            return LocalDateTime.parse(parts[0].trim(), ReportRecord.FORMATTER);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
