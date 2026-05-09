package CourseWork.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportRecord {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final LocalDateTime dateTime;
    private final String fileName;
    private final String operation;
    private final String status;

    public ReportRecord(LocalDateTime dateTime, String fileName, String operation, String status) {
        this.dateTime = dateTime;
        this.fileName = fileName;
        this.operation = operation;
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String toFileLine() {
        return dateTime.format(FORMATTER) + " | " + fileName + " | " + operation + " | " + status;
    }
}
