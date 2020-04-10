package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @NullSource
    void insert_StringMenuName_plusMenuNumber(String menuName) {
        assertThatThrownBy(() -> bill.insert(menuName)).isInstanceOf(NullPointerException.class)
                .hasMessage("메뉴 이름이 null 입니다");
    }

    @ParameterizedTest
    @NullSource
    void insert_invalidStringMenuName_ExceptionThrown(Menu menuName) {
        assertThatThrownBy(() -> bill.menuQuantity(menuName)).isInstanceOf(NullPointerException.class)
                .hasMessage("메뉴 이름이 null 입니다");
    }

    @Test
    void insert_StringMenuName_plusMenuNumber() {
        bill.insert("후라이드");
        Menu menu = MenuRepository.findMenuBy("후라이드");

        assertThat(bill.menuQuantity(menu)).isEqualTo(1);
    }
}