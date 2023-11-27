package menu.dto;

import menu.config.ErrorMessage;
import menu.exception.CoachNameException;

import java.util.List;

public record NameDTO(List<String> name) {
    public NameDTO(List<String> name) {
        validateNamesSize(name);
        validateNameSize(name);
        this.name = name;
    }

    private void validateNamesSize(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw new CoachNameException(ErrorMessage.INCORRECT_COACH_NUMBER.getMessage());
        }
    }

    private void validateNameSize(List<String> names) {
        for (String name : names) {
            if (name.length() < 2 || name.length() > 4) {
                throw new CoachNameException(ErrorMessage.INCORRECT_COACH_NAME.getMessage());
            }
        }
    }
}
