package modal;

import modal.exceptions.AuthorInvalidException;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class AuthorTest {

    @Test
    public void instance_validName_createsAuthor() {
        UUID id = UUID.randomUUID();

        Author author = Author.instance(id, "Antoine de Saint-Exupéry");

        assertNotNull(author);
        assertEquals(id, author.getUuid());
        assertEquals("Antoine de Saint-Exupéry", author.getName());
    }

    @Test
    public void instance_nullId_generatesId() {
        Author author = Author.instance(null, "Antoine de Saint-Exupéry");

        assertNotNull(author.getUuid());
    }

    @Test
    public void instance_nullName_throwsAuthorInvalidException() {
        assertThrows(AuthorInvalidException.class, () -> Author.instance(null, null));
    }

    @Test
    public void instance_blankName_throwsAuthorInvalidException() {
        assertThrows(AuthorInvalidException.class, () -> Author.instance(null, "  "));
    }

    @Test
    public void instance_nameTooLong_throwsAuthorInvalidException() {
        assertThrows(AuthorInvalidException.class, () -> Author.instance(null, "A".repeat(101)));
    }
}
