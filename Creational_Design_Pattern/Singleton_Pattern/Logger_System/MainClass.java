import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbstractLogger _logger;
        int choice, levelChoice;
        String Message;

        while (true) {
            System.out.println(
                    "\n---------- Menu ----------\n1. Log into Files\n2. Log to Console\n3. Log into Database\n4. Exit\n---------------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    _logger = FileLogger.GetLoggerInstance();
                    LogLevelMenu();
                    levelChoice = sc.nextInt();
                    switch (levelChoice) {
                        case 1:
                        case 2:
                        case 3:
                            sc.nextLine();
                            System.out.println("Enter the Message: ");
                            Message = sc.nextLine();
                            LogMessage(_logger,Message,levelChoice);
                            break;
                        case 4:
                            System.out.println("Not Implemented as of now.");
                            break;
                        default:
                            System.out.println("Invalid Choice !!!!");
                    }
                    break;

                case 2:
                case 3:
                    System.out.println("Not Implemented as of now.");
                    break;

                case 4:
                    sc.close();
                    System.out.println("Exiting from Program. GoodBye !!!");
                    return;

                default:
                    System.out.println("Invalid Choice !!!");
            }
        }
    }

    private static void LogLevelMenu() {
        System.out.println(
                "---------- Menu ----------\n1. Info\n2. Warning\n3. Error\n4. Exit\n------------------------------------");
        System.out.print("Enter your choice: ");
    }

    private static void LogMessage(AbstractLogger _logger, String Message, int Level) {
        if (Level == 1) {
            _logger.logInfo(Message);
        } else if (Level == 2) {
            _logger.logWarning(Message);
        } else {
            _logger.logError(Message);
        }
    }
}
