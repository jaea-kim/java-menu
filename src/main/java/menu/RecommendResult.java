package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendResult {
    Map<String, List<String>> results = new HashMap<>();

    public void addResult(String name, List<String> menus) {
        results.put(name, menus);
    }

    public Map<String, List<String>> getResults() {
        return results;
    }
}
