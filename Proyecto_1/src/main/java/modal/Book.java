package modal;

import java.util.UUID;

public class Book {
    private final UUID uuid;
    private final String titulo;
    private final String isbn;
    private final String genero;
    private final int paginas;
    private final String autor;

    // Constructor privado: solo accesible desde el método factory
    private Book(UUID uuid, String titulo, String isbn, String genero, int paginas, String autor) {
        this.uuid = uuid;
        this.titulo = titulo;
        this.isbn = isbn;
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
    }

    // Static Factory Method con validaciones
    public static Book instance(UUID uuid, String titulo, String isbn, String genero, int paginas, String autor) {
        // 1. Validación de UUID: si es nulo, autogeneramos uno
        UUID bookId = (uuid != null) ? uuid : UUID.randomUUID();

        // 2. Validación de Título
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo ni estar vacío.");
        }

        // 3. Validación de Páginas
        if (paginas <= 0) {
            throw new IllegalArgumentException("El número de páginas debe ser mayor a 0.");
        }

        // 4. Validación de Autor
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser nulo ni estar vacío.");
        }

        // 5. Validación de ISBN (normaliza guiones y verifica que tenga 10 o 13 dígitos numéricos)
        if (isbn == null || !isValidIsbn(isbn)) {
            throw new IllegalArgumentException("El formato del ISBN es inválido. Debe contener 10 o 13 dígitos.");
        }

        return new Book(bookId, titulo.trim(), isbn.trim(), genero, paginas, autor.trim());
    }

    // Método auxiliar privado para validar el ISBN
    private static boolean isValidIsbn(String isbn) {
        String cleanIsbn = isbn.replace("-", "").trim();
        // Acepta 10 o 13 dígitos (en ISBN-10 el último dígito puede ser una 'X'/'x')
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
