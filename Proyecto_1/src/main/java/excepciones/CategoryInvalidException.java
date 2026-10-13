package excepciones;

public class CategoryInvalidException extends IllegalArgumentException {
    public CategoryInvalidException(String message) {
        super(message);
    }
}
