package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTypeTest {

    @Test
    void findCommandBy_ValidCommand_returnCommandType() {
        assertThat(CommandType.findCommandBy(1)).isEqualTo(CommandType.REGISTER_ORDER);
    }

    @Test
    void findCommandBy_InvalidCommand_returnCommandType() {
        assertThatThrownBy(() -> CommandType.findCommandBy(4)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 명령입니다");
    }
}