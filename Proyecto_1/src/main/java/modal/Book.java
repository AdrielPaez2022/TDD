package modal;

import java.util.UUID;

public class Book {
    private final UUID uuid;
    private final String titulo;
    private final String isbn;
    private final String genero;
    private final int paginas;
    private final String autor;


    private Book(UUID uuid, String titulo, String isbn, String genero, int paginas, String autor) {
        this.uuid = uuid;
        this.titulo = titulo;
        this.isbn = isbn;
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
    }

    public static Book instance(UUID uuid, String titulo, String isbn, String genero, int paginas, String autor) {

        UUID bookId = (uuid != null) ? uuid : UUID.randomUUID();

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo ni estar vacío.");
        }


        if (paginas <= 0) {
            throw new IllegalArgumentException("El número de páginas debe ser mayor a 0.");
        }

        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser nulo ni estar vacío.");
        }

        if (isbn == null || !isValidIsbn(isbn)) {
            throw new IllegalArgumentException("El formato del ISBN es inválido. Debe contener 10 o 13 dígitos.");
        }

        return new Book(bookId, titulo.trim(), isbn.trim(), genero, paginas, autor.trim());
    }


    private static boolean isValidIsbn(String isbn) {
        String cleanIsbn = isbn.replace("-", "").trim();

        return cleanIsbn.matches("^(\\d{9}[\\dX]|\\d{13})$");
    }

    // Getters
    public UUID getUuid() {
        return uuid;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenero() {
        return genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getAutor() {
        return autor;
    }
}
