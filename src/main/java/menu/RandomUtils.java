package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.EnumMap;

public class RandomUtils {
    public static EnumMap<Weekend, Category> pickWeekendCategory() {
        EnumMap<Weekend, Category> randomCategory = new EnumMap<>(Weekend.class);

        int order = 0;
        for (Weekend weekend : Weekend.values()) {
            order = Randoms.pickNumberInRange(1, 5);
            while (getNumberOfCategory(randomCategory, Category.of(order)) > 1) {
                order = Randoms.pickNumberInRange(1, 5);
            }
            randomCategory.put(weekend, Category.of(order));
        }
        return randomCategory;
    }

    private static int getNumberOfCategory(EnumMap<Weekend, Category> selectedCategory, Category category) {
        return (int) selectedCategory.values().stream()
                .filter(c -> c == category)
                .count();
    }
}
