package menu.service;

import menu.domain.Category;
import menu.domain.Coaches;

public class RecommendService {
    private final Coaches coaches;

    public RecommendService(Coaches coaches) {
        this.coaches = coaches;
    }

    public RecommendResult recommendForOneDay(Category category, RecommendResult recommendResult) {
        return coaches.recommendMenusWithCategory(category, recommendResult);
    }
}
