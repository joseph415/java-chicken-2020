package domain;

import java.util.Arrays;

public enum Category {
    CHICKEN("치킨"),
    BEVERAGE("음료");

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    public static Category findCategoryBy(String category) {
        return Arrays.stream(Category.values())
                .filter(menu -> menu.getName().equals(category))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 번호입니다"));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
