package menu;

import menu.exception.CoachDislikeMenuException;
import menu.exception.CoachNameException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoachesCreator {
    private static CoachesCreator instance;
    private InputView inputView;
    private OutputView outputView;

    private CoachesCreator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static CoachesCreator getInstance(InputView inputView, OutputView outputView) {
        if (instance == null) {
            instance = new CoachesCreator(inputView, outputView);
        }
        return instance;
    }

    public Coaches createCoaches() {
        while (true) {
            try {
                String[] coachesName = inputCoachesName();
                List<Coach> coaches = createCoachesWithName(coachesName);
                return new Coaches(coaches);
            } catch (CoachNameException e) {
                printMessage(e.getMessage());
            }
        }
    }

    private List<Coach> createCoachesWithName(String[] coachesName) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachesName) {
            coaches.add(createCoach(coachName));
        }
        return coaches;
    }

    private Coach createCoach(String coachName) {
        DislikeMenus dislikeMenus = inputCoachesDislikeMenus(coachName);
        return new Coach(coachName, dislikeMenus);
    }

    private DislikeMenus inputCoachesDislikeMenus(String coachName) {
        while (true) {
            try {
                Optional<String[]> dislikeMenus = inputView.getCoachDislikeMenus(coachName);
                return new DislikeMenus(dislikeMenus);
            } catch (CoachDislikeMenuException e) {
                printMessage(e.getMessage());
            }
        }
    }

    private void printMessage(String message) {
        outputView.printMessage(message);
    }

    private String[] inputCoachesName() {
        return inputView.getCoachesName();
    }
}
