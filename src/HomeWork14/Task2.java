package HomeWork14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to input txt file: ");
        String inputPathString = scanner.nextLine().trim();

        Path inputPath = Paths.get(inputPathString);
        if (!Files.exists(inputPath) || !Files.isRegularFile(inputPath)) {
            System.out.println("File not found: " + inputPath.toAbsolutePath());
            return;
        }

        Path parentDir = inputPath.toAbsolutePath().getParent();
        Path validReportPath = parentDir.resolve("valid_documents_report.txt");
        Path invalidReportPath = parentDir.resolve("invalid_documents_report.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter validWriter = Files.newBufferedWriter(validReportPath);
             BufferedWriter invalidWriter = Files.newBufferedWriter(invalidReportPath)) {

            String documentNumber;
            while ((documentNumber = reader.readLine()) != null) {
                List<String> errors = validateDocumentNumber(documentNumber);

                if (errors.isEmpty()) {
                    validWriter.write(documentNumber);
                    validWriter.newLine();
                } else {
                    invalidWriter.write(documentNumber + " - invalid: " + String.join("; ", errors));
                    invalidWriter.newLine();
                }
            }

            System.out.println("Validation completed.");
            System.out.println("Valid document numbers: " + validReportPath);
            System.out.println("Invalid document numbers: " + invalidReportPath);

        } catch (IOException e) {
            System.out.println("File processing error: " + e.getMessage());
        }
    }

    private static List<String> validateDocumentNumber(String documentNumber) {
        List<String> errors = new ArrayList<>();

        if (documentNumber == null || documentNumber.isEmpty()) {
            errors.add("empty line");
            return errors;
        }

        if (documentNumber.length() != 15) {
            errors.add("length must be 15 characters");
        }

        if (!documentNumber.matches("[A-Za-z0-9]+")) {
            errors.add("only letters and digits are allowed");
        }

        if (!documentNumber.startsWith("docnum") && !documentNumber.startsWith("contract")) {
            errors.add("must start with docnum or contract");
        }

        return errors;
    }
}
