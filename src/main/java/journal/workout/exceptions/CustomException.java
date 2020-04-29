package journal.workout.exceptions;

import journal.workout.models.responses.ErrorBody;

public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }

    public ErrorBody errorBody() {
        return new ErrorBody(getMessage());
    }
}
