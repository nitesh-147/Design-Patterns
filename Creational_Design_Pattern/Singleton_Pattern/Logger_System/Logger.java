import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger _logger;
    private static final String _logFile = "log.txt";
    private static String _infoLevel = "INFORMATION";
    private static String _warningLevel = "WARNING";
    private static String _errorLevel = "ERROR";

    private Logger() {
        // Singleton Pattern is a usecase Where we can see the private constructor.
        // Usually Constructor is made public.
        System.out.println("Logger Inastace has been created.");
    }

    public static Logger GetLoggerInstance() {
        if (_logger == null) {
            _logger = new Logger();
        }
        return _logger;
    }

    public void logInfo(String message) {
        this.writeLogsToFile(getLogEntry(_infoLevel, message));
    }

    public void logWarning(String message) {
        this.writeLogsToFile(getLogEntry(_warningLevel, message));
    }

    public void logError(String message) {
        this.writeLogsToFile(getLogEntry(_errorLevel, message));
    }

    private String getTimeStamp() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return timestamp;
    }

    private String getLogEntry(String Level, String Message) {
        String LogEntry = String.format("[%s] [%s] %s", this.getTimeStamp(), Level, Message);
        return LogEntry;
    }

    private void writeLogsToFile(String LogEntry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(_logFile, true))) {
            writer.write(LogEntry);
            writer.newLine();
            System.out.println("Logged: " + LogEntry);
        } catch (IOException ex) {
            System.err.println("Error writing Log to the File : " + ex.getMessage());
        }
    }
}