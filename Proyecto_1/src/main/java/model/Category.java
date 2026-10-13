package model;

import excepciones.CategoryInvalidException;

import java.util.UUID;

public class Category {
    private final UUID uuid;
    private final String name;

    private Category(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public static Category instance(UUID uuid, String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 50) {
            throw new CategoryInvalidException("El nombre de la categoría debe contener entre 1 y 50 caracteres.");
        }

        UUID categoryId = uuid != null ? uuid : UUID.randomUUID();
        return new Category(categoryId, name.trim());
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
