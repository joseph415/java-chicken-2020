package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {

    @Test
    void insertMenu_MenuName_PlusMenu() {
        Table table = TableRepository.findTableNumberBy(1);
        table.insertMenu(1, 1);

        assertThat(table.menuQuantity(1)).isEqualTo(1);
    }

    @Test
    void sumAllMenuPrice_void_ReturnsSumALLMenuPrice() {
        Table table = TableRepository.findTableNumberBy(1);

        table.insertMenu(1, 3);
        table.insertMenu(3, 1);

        assertThat(table.sumAllMenuPrice()).isEqualTo(64000);
    }
}