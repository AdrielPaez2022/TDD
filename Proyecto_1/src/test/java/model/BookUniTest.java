package model;

import modal.Book;

public class BookUniTest {
    @Test

    //"id" , "autor" , "genero" , "isbn" , localDate.of(1990 , 8 , 1) , "paginas"
    void intanceBook_allFielOk_success(){
        Book mybook = Book.instance():


        assertions.assertNotNull(mybook);
    }

    //Act

    //Assert
}
