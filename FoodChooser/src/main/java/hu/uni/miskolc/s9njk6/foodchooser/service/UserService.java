package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;

public interface UserService {
    Iterable<UserDto> allUsers();

    void updateAdminUser(String email, String password) throws NoSuchEntityException;

    void deleteUser(String email, String password) throws NoSuchEntityException;
}
