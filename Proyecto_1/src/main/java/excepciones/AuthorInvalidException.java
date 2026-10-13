package excepciones;

public class AuthorInvalidException extends IllegalArgumentException {
    public AuthorInvalidException(String message) {
        super(message);
    }
}
