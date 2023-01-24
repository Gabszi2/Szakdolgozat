package hu.uni.miskolc.s9njk6.foodchooser.repository;

import java.util.Objects;

public class RecommendationEntity {
    private int id;
    private String type;
    private String kitchen;
    private String city;
    private String restaurant;
    private String message;
    private boolean approved;

    public RecommendationEntity() {
    }

    public RecommendationEntity(int id, String type, String kitchen, String city, String restaurant, String message, boolean approved) {
        this.id = id;
        this.type = type;
        this.kitchen = kitchen;
        this.city = city;
        this.restaurant = restaurant;
        this.message = message;
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "RecommendationEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", kitchen='" + kitchen + '\'' +
                ", city='" + city + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", message='" + message + '\'' +
                ", approved=" + approved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendationEntity that = (RecommendationEntity) o;
        return id == that.id && approved == that.approved && Objects.equals(type, that.type) && Objects.equals(kitchen, that.kitchen) && Objects.equals(city, that.city) && Objects.equals(restaurant, that.restaurant) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, kitchen, city, restaurant, message, approved);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
