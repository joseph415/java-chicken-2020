package domain;

public class Table {
    private final int number;
    private Bill bill;

    public Table(final int number) {
        this.number = number;
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

    public double sumPrice(PaymentMethod paymentMethod) {
        return Discount.discountPrice(bill, paymentMethod);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
