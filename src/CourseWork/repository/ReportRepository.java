package CourseWork.repository;

import CourseWork.model.ReportRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReportRepository {
    private final Path reportFile;

    public ReportRepository(Path reportFile) {
        this.reportFile = reportFile;
    }

    /**
     * Добавляет одну запись об операции в конец файла-отчета.
     */
    public void append(ReportRecord record) throws IOException {
        Files.createDirectories(reportFile.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(reportFile,
                java.nio.file.StandardOpenOption.CREATE,
                java.nio.file.StandardOpenOption.APPEND)) {
            writer.write(record.toFileLine());
            writer.newLine();
        }
    }

    /**
     * Читает все строки отчета или возвращает пустой список, если отчета еще нет.
     */
    public List<String> findAllLines() throws IOException {
        if (!Files.exists(reportFile)) {
            return new ArrayList<>();
        }

        return Files.readAllLines(reportFile);
    }
}
