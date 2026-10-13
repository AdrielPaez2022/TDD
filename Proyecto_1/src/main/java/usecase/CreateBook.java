package usecase;

import modal.Book;

import java.util.Objects;
import java.util.UUID;

public class CreateBook {
    private final BooksRepository booksRepository;

    public CreateBook(BooksRepository booksRepository) {
        this.booksRepository = Objects.requireNonNull(booksRepository, "booksRepository no puede ser nulo");
    }

    public Book registerBook(UUID uuid, String titulo, String isbn, String genero, int paginas, String autor) {
        Book newBook = Book.instance(uuid, titulo, isbn, genero, paginas, autor);

        if (booksRepository.existBook(newBook.getIsbn())) {
            throw new IllegalStateException("Ya existe un libro con el ISBN " + newBook.getIsbn() + ".");
        }

        if (!booksRepository.saveBook(newBook)) {
            throw new IllegalStateException("No se pudo guardar el libro.");
        }

        return newBook;
    }
}
