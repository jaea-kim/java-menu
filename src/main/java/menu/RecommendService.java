package menu;

import java.util.EnumMap;

public class RecommendService {
    private final Coaches coaches;

    public RecommendService(Coaches coaches) {
        this.coaches = coaches;
    }

    public RecommendResult recommend(EnumMap<Weekend, Category> selectedCategory) {

//        for (Map.Entry<Weekend, Category> entry : selectedCategory.entrySet()) {
//            Weekend key = entry.getKey();
//            Category value = entry.getValue();
//            System.out.println("Key: " + key + ", Value: " + value);
//        }
        return coaches.recommendMenusWithCategory(selectedCategory);
    }
}
