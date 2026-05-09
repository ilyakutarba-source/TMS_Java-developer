package CourseWork.repository;

import CourseWork.model.Account;
import CourseWork.util.AccountValidator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class AccountRepository {
    private final Path accountsFile;

    public AccountRepository(Path accountsFile) {
        this.accountsFile = accountsFile;
    }

    /**
     * Создает файл со стартовыми счетами, если файл счетов еще не существует.
     */
    public void createFileWithDefaultAccountsIfMissing() throws IOException {
        if (Files.exists(accountsFile)) {
            return;
        }

        Files.createDirectories(accountsFile.getParent());
        try (BufferedWriter writer = Files.newBufferedWriter(accountsFile)) {
            writer.write("11111-11111;1000.00");
            writer.newLine();
            writer.write("22222-22222;1500.50");
            writer.newLine();
            writer.write("33333-33333;700.00");
            writer.newLine();
        }
    }

    /**
     * Читает все счета из файла и возвращает их в виде Map по номеру счета.
     */
    public Map<String, Account> findAll() throws IOException {
        Map<String, Account> accounts = new LinkedHashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(accountsFile)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length != 2 || !AccountValidator.isValidAccountNumber(parts[0].trim())) {
                    throw new IOException("Invalid account record at line " + lineNumber);
                }

                try {
                    String accountNumber = parts[0].trim();
                    BigDecimal balance = new BigDecimal(parts[1].trim().replace(',', '.'));
                    accounts.put(accountNumber, new Account(accountNumber, balance));
                } catch (NumberFormatException e) {
                    throw new IOException("Invalid account balance at line " + lineNumber);
                }
            }
        }

        return accounts;
    }

    /**
     * Полностью перезаписывает файл счетов актуальными балансами.
     */
    public void saveAll(Map<String, Account> accounts) throws IOException {
        Files.createDirectories(accountsFile.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(accountsFile)) {
            for (Account account : accounts.values()) {
                writer.write(account.getNumber() + ";" + account.getBalance().stripTrailingZeros().toPlainString());
                writer.newLine();
            }
        }
    }
}
