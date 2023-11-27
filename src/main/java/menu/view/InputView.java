package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.config.ApplicationMessage;
import menu.dto.NameDTO;

import java.util.Arrays;
import java.util.Optional;

public class InputView {
    private static final String DELIMITER = ",";

    public NameDTO getCoachesName() {
        System.out.println(ApplicationMessage.INPUT_COACHES_NAME.getMessage());
        String input = Console.readLine();
        return inputToNameDTO(input);
    }

    private NameDTO inputToNameDTO(String input) {
        return new NameDTO(Arrays.asList(input.split(DELIMITER)));
    }

    public Optional<String[]> getCoachDislikeMenus(String coachName) {
        System.out.printf(ApplicationMessage.INPUT_DISLIKE_MENUS.getMessage(), coachName);
        String input = Console.readLine();
        return handleInputDislikeMenus(input);
    }

    private Optional<String[]> handleInputDislikeMenus(String input) {
        if (input.equals("")) {
            return Optional.empty();
        }
        return Optional.of(input.split(DELIMITER));
    }
}
