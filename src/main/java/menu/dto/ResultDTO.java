package menu.dto;

public record ResultDTO(String name, String menu) {
    public ResultDTO(String name, String menu) {
        this.name = name;
        this.menu = menu;
    }
}
