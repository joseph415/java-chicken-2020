import domain.CommandType;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Controller controller = new Controller();

        CommandType commandType = controller.getCommand();
        while (!controller.isCommandEnd(commandType)) {
            controller.posStart(commandType);
            commandType = controller.getCommand();
        }
    }
}
