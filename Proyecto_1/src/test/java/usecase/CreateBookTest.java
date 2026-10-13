package usecase;

import modal.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertSame;

public class CreateBookTest {

    @Test
    public void registerBook_savesAndReturnsBook() {
        InMemoryBooksRepository repository = new InMemoryBooksRepository();
        CreateBook createBook = new CreateBook(repository);

        Book book = createBook.registerBook(
                null, "El Principito", "9780156012195", "Ficción", 96, "Antoine"
        );

        assertEquals("El Principito", book.getTitulo());
        assertSame(book, repository.savedBook);
    }

    @Test
    public void registerBook_existingIsbn_throwsAndDoesNotSave() {
        InMemoryBooksRepository repository = new InMemoryBooksRepository();
        repository.isbnExists = true;
        CreateBook createBook = new CreateBook(repository);

        assertThrows(IllegalStateException.class, () -> createBook.registerBook(
                null, "El Principito", "9780156012195", "Ficción", 96, "Antoine"
        ));
        assertNull(repository.savedBook);
    }

    @Test
    public void registerBook_saveFails_throws() {
        InMemoryBooksRepository repository = new InMemoryBooksRepository();
        repository.saveSucceeds = false;
        CreateBook createBook = new CreateBook(repository);

        assertThrows(IllegalStateException.class, () -> createBook.registerBook(
                null, "El Principito", "9780156012195", "Ficción", 96, "Antoine"
        ));
    }

    private static class InMemoryBooksRepository implements BooksRepository {
        private boolean isbnExists;
        private boolean saveSucceeds = true;
        private Book savedBook;

        @Override
        public boolean saveBook(Book book) {
            if (saveSucceeds) {
                savedBook = book;
            }
            return saveSucceeds;
        }

        @Override
        public boolean existBook(String isbn) {
            return isbnExists;
        }
    }
}
