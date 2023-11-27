package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.config.Weekend;
import menu.domain.Category;

import java.util.EnumMap;

public class RandomUtils {
    public static Category pickWeekendCategory(EnumMap<Weekend, Category> randomCategory) {
        int order = Randoms.pickNumberInRange(1, 5);
        while (getNumberOfCategory(randomCategory, Category.of(order)) > 1) {
            order = Randoms.pickNumberInRange(1, 5);
        }
        return Category.of(order);
    }

    private static int getNumberOfCategory(EnumMap<Weekend, Category> selectedCategory, Category category) {
        return (int) selectedCategory.values().stream()
                .filter(c -> c == category)
                .count();
    }
}
