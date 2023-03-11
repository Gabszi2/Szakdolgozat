package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    ResponseEntity<List<UserDto>> allUsers() {
        List<UserDto> out = new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.UserDto userDto : userService.allUsers()) {
            out.add(new UserDto(userDto));
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    @DeleteMapping("/user/{email}/{password}")
    void deleteUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        userService.deleteUser(email, password);
    }

    @PutMapping("/user/{email}/{password}")
    void updateAdminUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        userService.updateAdminUser(email, password);
    }
}
