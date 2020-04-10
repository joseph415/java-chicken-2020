package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class discountTest {

    @Test
    void discountPrice_PaymentMethodIsCardAndChickQuantityMoreThanTen_returnDiscount() {
        Bill bill = new Bill();

        bill.insert(1, 10);
        assertThat(Discount.discountPrice(bill, PaymentMethod.CARD)).isEqualTo(150_000);
    }

    @Test
    void discountPrice_PaymentMethodIsMoney_returnDiscount() {
        Bill bill = new Bill();

        bill.insert(1, 1);
        assertThat(Discount.discountPrice(bill, PaymentMethod.MONEY)).isEqualTo(15200);
    }

    @Test
    void discountPrice_PaymentMethodIsMoneyAndChickQuantityMoreThanTen_returnDiscount() {
        Bill bill = new Bill();

        bill.insert(1, 10);
        assertThat(Discount.discountPrice(bill, PaymentMethod.MONEY)).isEqualTo(142_000);
    }
}