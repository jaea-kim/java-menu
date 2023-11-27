package menu.view;

import menu.RecommendResult;
import menu.config.Weekend;
import menu.config.ApplicationMessage;
import menu.domain.Category;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String RESULT_FORMAT = "[ %s | %s | %s | %s | %s | %s ]\n";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printResult(RecommendResult recommendResult) {
        for (Map.Entry<String, List<String>> entry : recommendResult.getResults().entrySet()) {
            List<String> menus = entry.getValue();
            System.out.printf(RESULT_FORMAT, entry.getKey(), menus.get(0), menus.get(1), menus.get(2), menus.get(3), menus.get(4));
        }
    }


    public void printCategoryResult(EnumMap<Weekend, Category> selectedCategory) {
        System.out.println(ApplicationMessage.RECOMMENDED_RESULTS.getMessage());
        System.out.printf(RESULT_FORMAT, "구분", "월요일", "화요일", "수요일", "목요일", "금요일");
        List<String> sortedCategoryList = selectedCategory.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(m -> m.getValue().getLabel())
                .toList();
        System.out.printf(RESULT_FORMAT, "카테고리", sortedCategoryList.get(0), sortedCategoryList.get(1), sortedCategoryList.get(2), sortedCategoryList.get(3), sortedCategoryList.get(4));
    }
}
