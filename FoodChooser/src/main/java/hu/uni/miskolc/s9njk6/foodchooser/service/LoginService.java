package hu.uni.miskolc.s9njk6.foodchooser.service;

public interface LoginService {
    UserDto login(String email,String password);
    UserDto register(UserDto newUser);
}
