package hu.uni.miskolc.s9njk6.foodchooser.service.exceptions;

public class NoSuchFoodException extends Exception {
    public NoSuchFoodException(){super("There is no food for this preference.");}
}
