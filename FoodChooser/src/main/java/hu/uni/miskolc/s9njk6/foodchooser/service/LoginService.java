package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;

public interface LoginService {
    UserDto login(String email, String password) throws NoSuchEntityException;

    UserDto register(UserDto newUser) throws EntityAlreadyExistsException;
}
