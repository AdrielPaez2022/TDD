package excepciones;

public class BookInvalidException extends IllegalArgumentException {
    public BookInvalidException(String message) {
        super(message);
    }
}
