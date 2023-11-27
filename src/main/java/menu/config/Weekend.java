package menu.config;

public enum Weekend {
    Monday("월요일"),
    Tuesday("화요일"),
    Wednesday("수요일"),
    Thursday("목요일"),
    Friday("금요일");

    private final String label;

    Weekend(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
