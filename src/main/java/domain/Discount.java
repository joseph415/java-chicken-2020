package domain;

public class Discount {
    private static final double MONEY_DISCOUNT_RATE = 0.05;
    private static final int CHICKEN_CATEGORY_DISCOUNT_PRICE = 10000;
    private static final int CHICKEN_COUNT_UNDER_BOUND = 10;

    public static double discountPrice(Bill bill, PaymentMethod paymentMethod) {
        double sumPrice = bill.sumAllMenuPrice();

        if (paymentMethod.isMoney()) {
            sumPrice -= (sumPrice * MONEY_DISCOUNT_RATE);
        }
        if (bill.countChickenCategory() >= CHICKEN_COUNT_UNDER_BOUND) {
            sumPrice -= CHICKEN_CATEGORY_DISCOUNT_PRICE * (bill.countChickenCategory() / CHICKEN_COUNT_UNDER_BOUND);
        }
        return sumPrice;
    }
}
