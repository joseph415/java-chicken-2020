package domain;

import java.util.Objects;

public class Table {
    private final int number;
    private Bill bill;

    public Table(final int number) {
        this.number = number;
        bill = new Bill();
    }

    public void insertMenu(String menuName) {
        Objects.requireNonNull(menuName, "메뉴이름이 null 입니다");

        bill.insert(menuName);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
