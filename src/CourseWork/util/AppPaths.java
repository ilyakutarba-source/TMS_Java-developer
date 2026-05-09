package CourseWork.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class AppPaths {
    public static final Path BASE_DIRECTORY = Paths.get("src", "CourseWork");
    public static final Path INPUT_DIRECTORY = BASE_DIRECTORY.resolve("input");
    public static final Path ARCHIVE_DIRECTORY = BASE_DIRECTORY.resolve("archive");
    public static final Path DATA_DIRECTORY = BASE_DIRECTORY.resolve("data");
    public static final Path REPORT_DIRECTORY = BASE_DIRECTORY.resolve("report");
    public static final Path ACCOUNTS_FILE = DATA_DIRECTORY.resolve("accounts.txt");
    public static final Path REPORT_FILE = REPORT_DIRECTORY.resolve("transfers_report.txt");

    /**
     * Запрещает создавать объект utility-класса.
     */
    private AppPaths() {
    }

    /**
     * Создает все папки, которые нужны программе для работы.
     */
    public static void createRequiredDirectories() {
        try {
            Files.createDirectories(INPUT_DIRECTORY);
            Files.createDirectories(ARCHIVE_DIRECTORY);
            Files.createDirectories(DATA_DIRECTORY);
            Files.createDirectories(REPORT_DIRECTORY);
        } catch (IOException e) {
            System.out.println("Cannot create project directories: " + e.getMessage());
        }
    }
}
