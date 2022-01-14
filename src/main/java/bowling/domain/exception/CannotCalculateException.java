package bowling.domain.exception;

public class CannotCalculateException extends RuntimeException {

    public CannotCalculateException() {
        super();
    }

    public CannotCalculateException(String message) {
        super(message);
    }

}

