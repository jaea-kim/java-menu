package menu;

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
