package menu;

import menu.config.ApplicationMessage;
import menu.domain.Coaches;
import menu.domain.CoachesCreator;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printMessage(ApplicationMessage.START.getMessage());

        CoachesCreator coachesCreator = CoachesCreator.getInstance(inputView, outputView);
        Coaches coaches = coachesCreator.createCoaches();

        RecommendService recommendService = new RecommendService(coaches);

        RecommendController recommendController = new RecommendController(recommendService, outputView);
        recommendController.execute();
    }
}
