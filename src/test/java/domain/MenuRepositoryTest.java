package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {

    @Test
    void findMenuBy_ValidMenuName_returnMenuInstance() {
        String menuName = "후라이드";

        assertThat(MenuRepository.findMenuBy(menuName)).isInstanceOf(Menu.class);
        assertThat(MenuRepository.findMenuBy(menuName).getName()).isEqualTo("후라이드");
    }

    @Test
    void findMenuBy_InvalidMenuName_ExceptionThrown() {
        String menuName = "subway";

        assertThatThrownBy(() -> MenuRepository.findMenuBy(menuName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다");
    }

    @ParameterizedTest
    @NullSource
    void findMenuBy_InvalidMenuName_ExceptionThrown(String menuName) {
        assertThatThrownBy(() -> MenuRepository.findMenuBy(menuName)).isInstanceOf(NullPointerException.class)
                .hasMessage("메뉴 이름이 null 입니다");
    }

    @Test
    void menus() {
        assertThat(MenuRepository.menus()).isInstanceOf(Collection.class);
    }
}