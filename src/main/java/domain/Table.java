package domain;

import java.util.Map;

public class Table {
    private final int number;
    private boolean isHaveGuest;
    private Bill bill;

    public Table(final int number) {
        this.number = number;
        this.isHaveGuest = false;
        bill = new Bill();
    }

    public void insertMenu(int menuNumber, int quantity) {
        bill.insert(menuNumber, quantity);
    }

    public int menuQuantity(int menuNumber) {
        return bill.menuQuantity(menuNumber);
    }

    public int getNumber() {
        return number;
    }

    public void switchedHaveGuestState() {
        if (this.isHaveGuest) {
            this.isHaveGuest = false;
        }
        this.isHaveGuest = true;
    }

    public boolean isHaveGuest() {
        return isHaveGuest;
    }

    public double sumPrice() {
        return bill.sumAllMenuPrice();
    }

    public double sumDiscountPrice(PaymentMethod paymentMethod) {
        return Discount.discountPrice(bill, paymentMethod);
    }

    public Map<Menu, Integer> getBill() {
        return bill.getBill();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
