package menu.controller;

import menu.util.RandomUtils;
import menu.service.RecommendResult;
import menu.service.RecommendService;
import menu.config.Weekend;
import menu.domain.Category;
import menu.view.OutputView;

import java.util.EnumMap;

public class RecommendController {
    private final RecommendService recommendService;
    private final OutputView outputView;

    public RecommendController(RecommendService recommendService, OutputView outputView) {
        this.recommendService = recommendService;
        this.outputView = outputView;
    }

    public void execute() {
        EnumMap<Weekend, Category> randomCategory = new EnumMap<>(Weekend.class);
        RecommendResult recommendResult = recommend(randomCategory);

        outputView.printCategoryResult(randomCategory);
        outputView.printResult(recommendResult);
    }

    private RecommendResult recommend(EnumMap<Weekend, Category> randomCategory) {
        RecommendResult recommendResult = new RecommendResult();

        for (Weekend weekend : Weekend.values()) {
            Category category = pickRandomCategory(randomCategory);
            randomCategory.put(weekend, category);
            recommendService.recommendForOneDay(category, recommendResult);
        }

        return recommendResult;
    }

    private Category pickRandomCategory(EnumMap<Weekend, Category> randomCategory) {
        return RandomUtils.pickWeekendCategory(randomCategory);
    }
}
