package hu.uni.miskolc.s9njk6.foodchooser.repository;

import java.util.Objects;

public class UserEntity {
    private String email;
    private String userName;
    private String password;
    private boolean admin;

    public UserEntity(String email, String userName, String password, boolean admin) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }

    public UserEntity() {
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
        return "UserEntity{" +
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
        UserEntity that = (UserEntity) o;
        return admin == that.admin && Objects.equals(email, that.email) && Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, userName, password, admin);
    }
}
