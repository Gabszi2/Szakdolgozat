package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @GetMapping("/login/{email}/{password}")
    ResponseEntity<UserDto> login(@PathVariable String email, @PathVariable String password){
        return new ResponseEntity<>(new UserDto(loginService.login(email,password)), HttpStatus.OK);
    }
    @PostMapping(value = "/register",consumes = "application/json")
    ResponseEntity<UserDto> register(@RequestBody @Valid UserDto userDto){
        return new ResponseEntity<>(new UserDto(loginService.register(userDto.toServiceUserDto())),HttpStatus.CREATED);
    }
}
