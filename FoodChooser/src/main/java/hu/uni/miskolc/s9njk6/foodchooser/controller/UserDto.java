package hu.uni.miskolc.s9njk6.foodchooser.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    private boolean admin;

    public UserDto() {
    }

    public UserDto(hu.uni.miskolc.s9njk6.foodchooser.service.UserDto userDto) {
        this.email = userDto.getEmail();
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.admin = userDto.isAdmin();
    }

    public hu.uni.miskolc.s9njk6.foodchooser.service.UserDto toServiceUserDto() {
        return new hu.uni.miskolc.s9njk6.foodchooser.service.UserDto(email, userName, password, admin);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}
