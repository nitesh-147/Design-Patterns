import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractLogger {
    private static final String INFO = "INFO";
    private static final String WARNING = "WARNING";
    private static final String ERROR = "ERROR";

    protected abstract void writeLog(String LogEntry);

    public void logInfo(String message) {
        writeLog(getLogEntry(INFO, message));
    }

    public void logWarning(String message) {
        writeLog(getLogEntry(WARNING, message));
    }

    public void logError(String message) {
        writeLog(getLogEntry(ERROR, message));
    }

    private String getTimeStamp() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return timestamp;
    }

    private String getLogEntry(String Level, String Message) {
        String LogEntry = String.format("[%s] [%s] %s", this.getTimeStamp(), Level, Message);
        return LogEntry;
    }
}
