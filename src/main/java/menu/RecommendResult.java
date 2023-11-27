package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendResult {
    Map<String, List<String>> results = new HashMap<>();

    public void addResult(String name, String menu) {
        List<String> menus = results.getOrDefault(name, new ArrayList<>());
        menus.add(menu);
        results.put(name, menus);
    }

    public Map<String, List<String>> getResults() {
        return results;
    }

    public boolean contains(String name, String menu) {
        List<String> menus = getCoachMenus(name);
        return menus.contains(menu);
    }

    private List<String> getCoachMenus(String name) {
        return results.getOrDefault(name, new ArrayList<>());
    }
}
