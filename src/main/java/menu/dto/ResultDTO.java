package menu.dto;

import java.util.List;

public record ResultDTO(String name, String menu) {
    public ResultDTO(String name, String menu) {
        this.name = name;
        this.menu = menu;
    }
}
