package hu.uni.miskolc.s9njk6.foodchooser.service.exceptions;

public class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String entity) {
        super("No such entity: " + entity);
    }
}
