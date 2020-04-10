package domain;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {

    @Test
    void findMenuBy_ValidMenuName_returnMenuInstance() {
        int menuName = 1;

        assertThat(MenuRepository.findMenuBy(menuName)).isInstanceOf(Menu.class);
        assertThat(MenuRepository.findMenuBy(menuName).getName()).isEqualTo("후라이드");
    }

    @Test
    void findMenuBy_InvalidMenuName_ExceptionThrown() {
        int menuName = 9;

        assertThatThrownBy(() -> MenuRepository.findMenuBy(menuName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 번호입니다");
    }

    @Test
    void menus() {
        assertThat(MenuRepository.menus()).isInstanceOf(Collection.class);
    }
}