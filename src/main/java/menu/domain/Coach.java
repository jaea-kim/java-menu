package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.config.ErrorMessage;
import menu.config.Weekend;
import menu.dto.ResultDTO;
import menu.exception.CoachNameException;

import java.util.ArrayList;
import java.util.EnumMap;
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

    public ResultDTO recommendMenusWithCategory(EnumMap<Weekend, Category> selectedCategory) {
        List<String> menus = new ArrayList<>();

        for (Category category : selectedCategory.values()) {
            menus.add(recommendMenu(menus, category));
        }

        return new ResultDTO(name, menus);
    }

    private String recommendMenu(List<String> recommend, Category category) {
        while (true) {
            String menu = Randoms.shuffle(category.getMenus()).get(0);
            if (!recommend.contains(menu) && !dislikeMenus.contains(menu)) {
                return menu;
            }
        }
    }
}
