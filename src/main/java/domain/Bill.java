package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bill {
    private final Map<Menu, Integer> bill = new HashMap<>();

    public Bill() {
        MenuRepository.menus().forEach(menu -> bill.put(menu, 0));
    }

    public void insert(String menuName) {
        Objects.requireNonNull(menuName, "메뉴 이름이 null 입니다");
        Menu menu = MenuRepository.findMenuBy(menuName);

        bill.put(menu, bill.get(menu) + 1);
    }

    public int menuQuantity(Menu menuName) {
        Objects.requireNonNull(menuName, "메뉴 이름이 null 입니다");
        return bill.get(menuName);
    }

    public Map<Menu, Integer> getBill() {
        return Collections.unmodifiableMap(bill);
    }
}
