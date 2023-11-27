package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.RecommendResult;
import menu.config.ErrorMessage;
import menu.dto.ResultDTO;
import menu.exception.CoachNameException;

import java.util.List;

public class Coach {
    private final String name;
    private final DislikeMenus dislikeMenus;

    public Coach(String name, DislikeMenus dislikeMenus) {
        validateNameSize(name);
        this.name = name;
        this.dislikeMenus = dislikeMenus;
    }

    private void validateNameSize(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new CoachNameException(ErrorMessage.INCORRECT_COACH_NAME.getMessage());
        }
    }

    public ResultDTO recommendMenusWithCategory(Category category, RecommendResult recommendResult) {
        while (true) {
            String menu = Randoms.shuffle(category.getMenus()).get(0);
            if (!recommendResult.contains(name,menu) && !dislikeMenus.contains(menu)) {
                return new ResultDTO(name, menu);
            }
        }
    }
}
