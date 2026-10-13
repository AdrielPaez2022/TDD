package usecase;

import model.Book;

public interface BooksRepository {
    boolean saveBook(Book book);

    boolean existBook(String isbn);
}
