package hu.uni.miskolc.s9njk6.foodchooser.service.exceptions;

public class EntityAlreadyExistsException extends Exception {
    public EntityAlreadyExistsException(String entity) {
        super("Entity already exists: "+entity);
    }
}
