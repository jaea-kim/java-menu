package menu.exception;

import menu.ErrorMessage;

public class CoachDislikeMenuException extends IllegalArgumentException {
    public CoachDislikeMenuException(String message) {
        super(message);
    }
}
