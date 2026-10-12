package modal.exceptions;

public class AuthorInvalidException extends IllegalArgumentException {
    public AuthorInvalidException(String message) {
        super(message);
    }
}
