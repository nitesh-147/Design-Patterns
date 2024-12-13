import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLogger {
    private static FileLogger _logger;
    private static final String _logFile = "log.txt";

    private FileLogger() {
        // Singleton Pattern is a usecase Where we can see the private constructor.
        // Usually Constructor is made public.
        this.logInfo("Logger Instance has been Created.");
    }

    public static FileLogger GetLoggerInstance() {
        if (_logger == null) {
            _logger = new FileLogger();
        }
        return _logger;
    }

    @Override
    protected void writeLog(String LogEntry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(_logFile, true))) {
            writer.write(LogEntry);
            writer.newLine();
            System.out.println("Logged: " + LogEntry);
        } catch (IOException ex) {
            System.err.println("Error writing Log to the File : " + ex.getMessage());
        }
    }
}