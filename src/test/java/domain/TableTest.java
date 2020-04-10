package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableTest {

    @ParameterizedTest
    @NullSource
    void insertMenu_MenuNameIsNull_ExceptionThrown(String menuName) {
        Table table = TableRepository.findTableNumberBy(1);
        assertThatThrownBy(() -> table.insertMenu(menuName)).isInstanceOf(NullPointerException.class)
                .hasMessage("메뉴 이름이 null 입니다.");
    }

    @Test
    void insertMenu_MenuName_PlusMenu() {
        Table table = TableRepository.findTableNumberBy(1);
        table.insertMenu("후라이드");
    }

    @Test
    void testToString() {
    }
}