package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bill {
    private static final int PURCHASE_UPPER_BOUND = 99;
    private final Map<Menu, Integer> bill = new HashMap<>();

    public Bill() {
        MenuRepository.menus().forEach(menu -> bill.put(menu, 0));
    }

    public void insert(String menuName, int quantity) {
        Objects.requireNonNull(menuName, "메뉴 이름이 null 입니다");

        if (menuQuantity(menuName) > PURCHASE_UPPER_BOUND) {
            throw new IllegalArgumentException("최대 구매 수량은 99개 입니다");
        }

        Menu menu = MenuRepository.findMenuBy(menuName);
        bill.put(menu, bill.get(menu) + quantity);
    }

    public int menuQuantity(String menuName) {
        Objects.requireNonNull(menuName, "메뉴 이름이 null 입니다");

        Menu menu = MenuRepository.findMenuBy(menuName);
        return bill.get(menu);
    }

    public Map<Menu, Integer> getBill() {
        return Collections.unmodifiableMap(bill);
    }
}
