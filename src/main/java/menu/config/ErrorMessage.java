package menu.config;

public enum ErrorMessage {
    INCORRECT_COACH_NUMBER("코치 인원 수가 잘못 입력되었습니다."),
    INCORRECT_COACH_NAME("코치 이름이 잘못 입력되었습니다."),
    INCORRECT_MENU_NUMBER("음식 종류가 잘못 입력되었습니다."),
    NO_MENU("음식 잘못 입력되었습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
