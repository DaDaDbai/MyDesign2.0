package exception;

public class noPersonFoundException extends Exception{
    public noPersonFoundException() {
    }

    public noPersonFoundException(String message) {
        super(message);
    }
}
