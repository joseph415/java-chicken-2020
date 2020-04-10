package domain;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {

    @Test
    void findTableNumberBy_ValidTableNumber_returnTable() {
        int tableNumber = 3;
        assertThat(TableRepository.findTableNumberBy(tableNumber)).isInstanceOf(Table.class);
    }

    @Test
    void findTableNumberBy_inValidTableNumber_ExceptionThrown() {
        int tableNumber = 4;
        assertThatThrownBy(() -> TableRepository.findTableNumberBy(tableNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 테이블 번호입니다");
    }

    @Test
    void tables() {
        assertThat(TableRepository.tables()).isInstanceOf(Collection.class);
    }
}