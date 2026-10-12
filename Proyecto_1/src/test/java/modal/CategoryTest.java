package modal;

import modal.exceptions.CategoryInvalidException;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class CategoryTest {

    @Test
    public void instance_validName_createsCategory() {
        UUID id = UUID.randomUUID();

        Category category = Category.instance(id, "Ficción");

        assertNotNull(category);
        assertEquals(id, category.getUuid());
        assertEquals("Ficción", category.getName());
    }

    @Test
    public void instance_nullId_generatesId() {
        Category category = Category.instance(null, "Ficción");

        assertNotNull(category.getUuid());
    }

    @Test
    public void instance_nullName_throwsCategoryInvalidException() {
        assertThrows(CategoryInvalidException.class, () -> Category.instance(null, null));
    }

    @Test
    public void instance_blankName_throwsCategoryInvalidException() {
        assertThrows(CategoryInvalidException.class, () -> Category.instance(null, "  "));
    }

    @Test
    public void instance_nameTooLong_throwsCategoryInvalidException() {
        assertThrows(CategoryInvalidException.class, () -> Category.instance(null, "A".repeat(51)));
    }
}
