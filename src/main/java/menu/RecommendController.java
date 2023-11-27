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
       // Cateogry pickedCategory = randomCateogry();
//        EnumMap<Weekend, Category> selectedCategory = RandomUtils.pickWeekendCategory();
//        outputView.printCategoryResult(selectedCategory);
//        RecommendResult recommendResult = recommendService.recommend(selectedCategory);
//        outputView.printResult(recommendResult);
        EnumMap<Weekend, Category> randomCategory = new EnumMap<>(Weekend.class);
        RecommendResult recommendResult = new RecommendResult();

        for (Weekend weekend : Weekend.values()) {
            Category category = pickRandomCategory(randomCategory);
            randomCategory.put(weekend, category);
            recommendService.recommendForOneDay(category, recommendResult);
        }

        outputView.printCategoryResult(randomCategory);
        outputView.printResult(recommendResult);
    }

    private Category pickRandomCategory(EnumMap<Weekend, Category> randomCategory) {
        return RandomUtils.pickWeekendCategory(randomCategory);
    }
}
