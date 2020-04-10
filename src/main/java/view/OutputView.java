package view;

import domain.Menu;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String isHaveGuest = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printPayTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printPayLine(BOTTOM_LINE, size, tables);
    }

    public static void printMainTodo() {
        System.out.println(String.format("%s\n%s\n%s\n%s\n", "##메인화면", "1 - 주문등록", "2 - 결제하기", "3 - 프로그램 종료"));
    }

    public static void printOrderDetails(Table table) {
        System.out.println("##주문 내역\n메뉴 수량 금액");
        Map<Menu, Integer> bills = table.getBill();
        bills.forEach((key, value) -> {
            if (value > 0) {
                System.out.printf("%s %d %d원\n", key.getName(), value, (int) table.sumPrice());
            }
        });
        System.out.printf("%d번 테이블의 결제를 진행합니다\n", table.getNumber());
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printPayLine(final String line, final int count, final List<Table> tables) {
        for (int index = 0; index < count; index++) {
            if (tables.get(index).isHaveGuest()) {
                System.out.print(isHaveGuest);
                continue;
            }
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printPaymentPrice(double sumPrice) {
        System.out.printf("최종 결제 금액: %d\n", (int) sumPrice);
    }
}
