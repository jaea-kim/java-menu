package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Optional;

public class InputView {
    private static final String DELIMITER = ",";

    public String[] getCoachesName() {
        System.out.println(ApplicationMessage.INPUT_COACHES_NAME.getMessage());
        String input = Console.readLine();
        return input.split(DELIMITER);
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
