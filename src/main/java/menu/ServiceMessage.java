package menu;

public enum ServiceMessage {
    START("점심 메뉴 추천을 시작합니다."),
    INPUT_COACHES_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_UNFAVORABLE_MENUS("%s (이)가 못 먹는 메뉴를 입력해 주세요."),
    RECOMMENDED_RESULTS("메뉴 추천 결과입니다."),
    END("추천을 완료했습니다.");

    private String message;

    ServiceMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
