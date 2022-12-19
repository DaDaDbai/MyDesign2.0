package exception;

public class queueEmptyException extends Exception{
    public queueEmptyException() {
    }

    public queueEmptyException(String message) {
        super(message);
    }
}
