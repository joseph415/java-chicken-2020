package domain;

import java.util.Arrays;

public enum CommandType {
    REGISTER_ORDER(1),
    PAYMENT(2),
    END(3);

    private int command;

    CommandType(int command) {
        this.command = command;
    }

    public static CommandType findCommandBy(int command) {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> commandType.getCommand() == command)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 명령입니다"));
    }

    public boolean isEnd() {
        return this.equals(END);
    }

    private int getCommand() {
        return command;
    }
}
