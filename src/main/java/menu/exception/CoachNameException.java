package menu.exception;

import menu.ErrorMessage;

public class CoachNameException extends IllegalArgumentException {
    public CoachNameException(String message) {
        super(message);
    }
}
