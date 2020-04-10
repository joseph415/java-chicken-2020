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

    @Test
    void countChickenCategory_ChickenCountTen_returnTen() {
        bill.insert(1, 10);

        assertThat(bill.countChickenCategory()).isEqualTo(10);
    }

    @Test
    void sumAllMenuPrice_void_ReturnsSumALLMenuPrice() {
        bill.insert(1, 3);
        bill.insert(3, 1);

        assertThat(bill.sumAllMenuPrice()).isEqualTo(64000);
    }
}