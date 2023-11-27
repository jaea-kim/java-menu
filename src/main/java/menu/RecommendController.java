package menu;

import menu.config.Weekend;
import menu.domain.Category;
import menu.view.OutputView;

import java.util.EnumMap;

public class RecommendController {
    private RecommendService recommendService;
    private OutputView outputView;

    public RecommendController(RecommendService recommendService, OutputView outputView) {
        this.recommendService = recommendService;
        this.outputView = outputView;
    }

    public void execute() {
        EnumMap<Weekend, Category> selectedCategory = RandomUtils.pickWeekendCategory();
        outputView.printCategoryResult(selectedCategory);
        RecommendResult recommendResult = recommendService.recommend(selectedCategory);
        outputView.printResult(recommendResult);
    }
}
