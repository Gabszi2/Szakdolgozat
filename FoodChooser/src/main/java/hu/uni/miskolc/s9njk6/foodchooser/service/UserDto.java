package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.UserEntity;

import java.util.Objects;

public class UserDto {
    private String email;
    private String userName;
    private String password;
    private boolean admin;

    public UserDto() {
    }

    public UserDto(String email, String userName, String password, boolean admin) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }
    public UserDto(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.userName = userEntity.getUserName();
        this.password = userEntity.getPassword();
        this.admin = userEntity.isAdmin();
    }
public UserEntity toUserEntity(){
        return new UserEntity(email,userName,password,admin);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return admin == userDto.admin && Objects.equals(email, userDto.email) && Objects.equals(userName, userDto.userName) && Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, userName, password, admin);
    }
}
