package menu.domain;

import menu.RecommendResult;
import menu.config.ErrorMessage;
import menu.dto.ResultDTO;
import menu.exception.CoachNameException;

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

    public RecommendResult recommendMenusWithCategory(Category category, RecommendResult recommendResult) {
        for (Coach coach : coaches) {
            ResultDTO resultDTO = coach.recommendMenusWithCategory(category, recommendResult);
            recommendResult.addResult(resultDTO.name(), resultDTO.menu());
        }
        return recommendResult;
    }
}
