package model;


import modal.Book;
import org.junit.Test;
import java.util.UUID;
import static org.junit.Assert.*;

public class BookUniTest {

    @Test
    public void instanceBook_allFieldsOk_success() {
        UUID id = UUID.randomUUID();
        Book myBook = Book.instance(
                id,
                "El Principito",
                "9780156012195",
                "Ficción",
                96,
                "Antoine de Saint-Exupéry"
        );

        assertNotNull(myBook);
        assertEquals(id, myBook.getUuid());
        assertEquals("El Principito", myBook.getTitulo());
        assertEquals(96, myBook.getPaginas());
    }

    @Test
    public void instanceBook_nullOrBlankTitle_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Book.instance(UUID.randomUUID(), "", "9780156012195", "Ficción", 96, "Antoine");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Book.instance(UUID.randomUUID(), null, "9780156012195", "Ficción", 96, "Antoine");
        });
    }

    @Test
    public void instanceBook_zeroOrNegativePages_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Book.instance(UUID.randomUUID(), "El Principito", "9780156012195", "Ficción", 0, "Antoine");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Book.instance(UUID.randomUUID(), "El Principito", "9780156012195", "Ficción", -10, "Antoine");
        });
    }

    @Test
    public void instanceBook_invalidIsbnFormat_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Book.instance(UUID.randomUUID(), "El Principito", "123", "Ficción", 96, "Antoine");
        });
    }

    @Test
    public void instanceBook_nullAuthor_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Book.instance(UUID.randomUUID(), "El Principito", "9780156012195", "Ficción", 96, null);
        });
    }
}