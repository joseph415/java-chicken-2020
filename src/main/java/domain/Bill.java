package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bill {
    private static final int PURCHASE_UPPER_BOUND = 99;
    private final Map<Menu, Integer> bill = new HashMap<>();

    public Bill() {
        MenuRepository.menus().forEach(menu -> bill.put(menu, 0));
    }

    public double countChickenCategory() {
        return bill.entrySet().stream()
                .filter(entry -> entry.getKey().getCategory() == Category.CHICKEN)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public void insert(int menuNumber, int quantity) {
        if (menuQuantity(menuNumber) + quantity > PURCHASE_UPPER_BOUND) {
            throw new IllegalArgumentException("최대 구매 수량은 99개 입니다");
        }

        Menu menu = MenuRepository.findMenuBy(menuNumber);
        bill.put(menu, bill.get(menu) + quantity);
    }

    public int menuQuantity(int menuNumber) {
        Menu menu = MenuRepository.findMenuBy(menuNumber);

        return bill.get(menu);
    }

    public int sumAllMenuPrice() {
        return bill.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * (entry.getKey().getPrice()))
                .sum();
    }

    public Map<Menu, Integer> getBill() {
        return Collections.unmodifiableMap(bill);
    }
}
