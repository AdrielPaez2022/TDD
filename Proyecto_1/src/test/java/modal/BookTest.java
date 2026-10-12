package modal;

import modal.exceptions.BookInvalidException;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class BookTest {

    @Test
    public void instance_validData_createsBook() {
        UUID id = UUID.randomUUID();

        Book book = Book.instance(id, "El Principito", "9780156012195", "Ficción", 96, "Antoine");

        assertNotNull(book);
        assertEquals(id, book.getUuid());
        assertEquals("El Principito", book.getTitulo());
    }

    @Test
    public void instance_nullId_generatesId() {
        Book book = Book.instance(null, "El Principito", "9780156012195", "Ficción", 96, "Antoine");

        assertNotNull(book.getUuid());
    }

    @Test
    public void instance_invalidTitle_throwsBookInvalidException() {
        assertThrows(BookInvalidException.class,
                () -> Book.instance(null, " ", "9780156012195", "Ficción", 96, "Antoine"));
    }

    @Test
    public void instance_invalidPages_throwsBookInvalidException() {
        assertThrows(BookInvalidException.class,
                () -> Book.instance(null, "El Principito", "9780156012195", "Ficción", 0, "Antoine"));
    }

    @Test
    public void instance_invalidAuthor_throwsBookInvalidException() {
        assertThrows(BookInvalidException.class,
                () -> Book.instance(null, "El Principito", "9780156012195", "Ficción", 96, " "));
    }

    @Test
    public void instance_invalidIsbn_throwsBookInvalidException() {
        assertThrows(BookInvalidException.class,
                () -> Book.instance(null, "El Principito", "123", "Ficción", 96, "Antoine"));
    }
}
