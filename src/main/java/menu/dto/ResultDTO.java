package menu.dto;

import java.util.List;

public record ResultDTO(String name, List<String> menus) {
    public ResultDTO(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }
}
