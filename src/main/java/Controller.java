import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    final List<Table> tables;
    final List<Menu> menus;

    public Controller() {
        tables = TableRepository.tables();
        menus = MenuRepository.menus();
    }

    public void posStart(CommandType commandType) {
        switch (commandType) {
            case REGISTER_ORDER: {
                OutputView.printTables(tables);
                Table table = TableRepository.findTableNumberBy(InputView.inputTableNumber());
                table.switchedHaveGuestState();

                OutputView.printMenus(menus);
                final int menuNumber = InputView.inputMenuNumber();
                final int menuCount = InputView.inputMenuCount();
                table.insertMenu(menuNumber, menuCount);
                break;
            }
            case PAYMENT: {
                OutputView.printPayTables(tables);
                Table table = TableRepository.findTableNumberBy(InputView.inputTableNumber());

                OutputView.printOrderDetails(table);
                final int paymentMethod = InputView.inputPaymentMethod();
                double sumPrice = table.sumDiscountPrice(PaymentMethod.findPaymentMethodBy(paymentMethod));
                table.switchedHaveGuestState();

                OutputView.printPaymentPrice(sumPrice);
                break;
            }
        }
    }

    public CommandType getCommand() {
        OutputView.printMainTodo();
        return CommandType.findCommandBy(InputView.inputMainTodo());
    }

    public boolean isCommandEnd(CommandType commandType) {
        return commandType.isEnd();
    }
}
