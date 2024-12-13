public class ConsoleLogger extends AbstractLogger {
    private static ConsoleLogger _logger;

    private ConsoleLogger() {
        System.out.println("Console logger Instance has been created.");
    }

    public static ConsoleLogger getLoggerInstance() {
        if (_logger == null) {
            _logger = new ConsoleLogger();
        }
        return _logger;
    }

    @Override
    protected void writeLog(String LogEntry) {
        System.out.println(LogEntry);
    }

}
