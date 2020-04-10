package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BillTest {
    private Bill bill;

    @BeforeEach
    void setUp() {
        bill = new Bill();
    }

    @Test
    void Bill_GenerateInstance_returnInstance() {
        assertThat(new Bill()).isInstanceOf(Bill.class);
    }

    @Test
    void insert_StringMenuName_plusMenuNumber() {
        bill.insert(1, 1);

        assertThat(bill.menuQuantity(1)).isEqualTo(1);
    }
}