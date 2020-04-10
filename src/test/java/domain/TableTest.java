package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {
    private Table table;

    @BeforeEach
    void setUp() {
        table = new Table(1);
    }

    @Test
    void insertMenu_MenuName_PlusMenu() {
        table.insertMenu(1, 1);

        assertThat(table.menuQuantity(1)).isEqualTo(1);
    }

    @Test
    void sumPrice_PaymentMethodIsCardAndChickQuantityMoreThanTen_returnDiscount() {
        table.insertMenu(1, 10);
        assertThat(table.sumPrice(PaymentMethod.CARD)).isEqualTo(150_000);
    }

    @Test
    void sumPrice_PaymentMethodIsMoney_returnDiscount() {
        table.insertMenu(1, 1);
        assertThat(table.sumPrice(PaymentMethod.MONEY)).isEqualTo(15200);
    }

    @Test
    void sumPrice_PaymentMethodIsMoneyAndChickQuantityMoreThanTen_returnDiscount() {
        table.insertMenu(1, 10);
        assertThat(table.sumPrice(PaymentMethod.MONEY)).isEqualTo(142_000);
    }
}