package modal;

import modal.exceptions.AuthorInvalidException;

import java.util.UUID;

public class Author {
    private final UUID uuid;
    private final String name;

    private Author(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public static Author instance(UUID uuid, String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > 100) {
            throw new AuthorInvalidException("El nombre del autor debe contener entre 1 y 100 caracteres.");
        }

        UUID authorId = uuid != null ? uuid : UUID.randomUUID();
        return new Author(authorId, name.trim());
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
