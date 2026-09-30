package modal;

import java.util.UUID;

public class Book {
    public static Book instance(UUID uuid , String cleanCode , String icbn , String genero , int pagina , String autor){
        return new Book();
    };
}
