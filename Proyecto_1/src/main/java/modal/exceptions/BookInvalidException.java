package modal.exceptions;

public class BookInvalidException extends IllegalArgumentException {
    public BookInvalidException(String message) {
        super(message);
    }
}
