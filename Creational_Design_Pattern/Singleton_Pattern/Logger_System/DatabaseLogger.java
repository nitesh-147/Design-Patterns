public class DatabaseLogger extends AbstractLogger{

    private static DatabaseLogger _logger;
    private static String Level;

    private DatabaseLogger(){
        
    }

    public DatabaseLogger GetLoggerInstance(){
        if(_logger == null){
            _logger = new DatabaseLogger();
        }

        return _logger;
    }

    @Override
    protected void writeLog(String LogEntry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeLog'");
    }

    @Override
    public void logInfo(String Message){
        Level = "INFO";
        this.writeLog(Message);
    }

    @Override
    public void logWarning(String Message) {
        Level = "WARNING";
        this.writeLog(Message);
    }

    @Override
    public void logError(String Message) {
        Level = "ERROR";
        this.writeLog(Message);
    }
    
}
