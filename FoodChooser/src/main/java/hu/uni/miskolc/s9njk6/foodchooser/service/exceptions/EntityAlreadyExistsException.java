package hu.uni.miskolc.s9njk6.foodchooser.service.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String entity) {
        super("Entity already exists: " + entity);
    }
}
