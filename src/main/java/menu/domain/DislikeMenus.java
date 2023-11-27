package menu.domain;

import menu.config.ErrorMessage;
import menu.exception.CoachDislikeMenuException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DislikeMenus {
    private final List<String> dislikeMenus;

    public DislikeMenus(Optional<String[]> dislikeMenus) {
        if (dislikeMenus.isPresent()) {
            this.dislikeMenus = List.of(dislikeMenus.get());
            validateSize(this.dislikeMenus);
            validateName(this.dislikeMenus);
            return;
        }
        this.dislikeMenus = Collections.emptyList();
    }

    private void validateName(List<String> dislikeMenus) {
        if (dislikeMenus != null) {
            if (!dislikeMenus.stream().allMatch(Category::isInMenus)) {
                throw new CoachDislikeMenuException(ErrorMessage.NO_MENU.getMessage());
            }
        }
    }

    private void validateSize(List<String> dislikeMenus) {
        if (dislikeMenus != null) {
            if (dislikeMenus.size() > 2) {
                throw new CoachDislikeMenuException(ErrorMessage.INCORRECT_MENU_NUMBER.getMessage());
            }
        }
    }

    public boolean contains(String menu) {
        return dislikeMenus.contains(menu);
    }
}
