package domain;

import java.util.Arrays;

public enum PaymentMethod {
    CARD(1),
    MONEY(2);

    private int paymentNumber;

    PaymentMethod(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public static PaymentMethod findPaymentMethodBy(int paymentNumber) {
        return Arrays.stream(PaymentMethod.values())
                .filter(paymentMethod -> paymentMethod.getPaymentNumber() == paymentNumber).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 결제 방식 입니다"));
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public boolean isMoney() {
        return this.equals(MONEY);
    }
}
