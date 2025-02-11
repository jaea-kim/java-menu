package menu;

import menu.exception.CoachNameException;

import java.util.EnumMap;
import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateSize(coaches);
        this.coaches = coaches;
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < 2 || coaches.size() > 5) {
            throw new CoachNameException(ErrorMessage.INCORRECT_COACH_NUMBER.getMessage());
        }
    }

    public RecommendResult recommendMenusWithCategory(EnumMap<Weekend, Category> selectedCategory) {
        RecommendResult recommendResult = new RecommendResult();
        for (Coach coach : coaches) {
            ResultDTO resultDTO = coach.recommendMenusWithCategory(selectedCategory);
            recommendResult.addResult(resultDTO.name(), resultDTO.menus());
        }
        return recommendResult;
    }
}
