package menu.domain;

import menu.dto.NameDTO;
import menu.exception.CoachDislikeMenuException;
import menu.exception.CoachNameException;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoachesCreator {
    private static CoachesCreator instance;
    private final InputView inputView;
    private final OutputView outputView;

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
                NameDTO coachesName = inputCoachesName();
                List<Coach> coaches = createCoachesWithName(coachesName);
                return new Coaches(coaches);
            } catch (CoachNameException e) {
                printMessage(e.getMessage());
            }
        }
    }

    private List<Coach> createCoachesWithName(NameDTO coachesName) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachesName.name()) {
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

    private NameDTO inputCoachesName() {
        return inputView.getCoachesName();
    }
}
