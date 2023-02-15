package hu.uni.miskolc.s9njk6.foodchooser.controller;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class RecommendationDto {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String type;
    private String kitchen;
    private String city;
    private String foodName;
    private String restaurant;
    @NotEmpty
    private String message;
    private boolean approved;

    public RecommendationDto() {
    }

    public RecommendationDto(hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto recommendationDto) {
        this.id = recommendationDto.getId();
        this.type = recommendationDto.getType();
        this.kitchen = recommendationDto.getKitchen();
        this.city = recommendationDto.getCity();
        this.foodName=recommendationDto.getFoodName();
        this.restaurant = recommendationDto.getRestaurant();
        this.message = recommendationDto.getMessage();
        this.approved = recommendationDto.isApproved();
    }
    public hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto toServiceRecommendationDto(){
        return new hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto(id,type,kitchen,city,foodName,restaurant,message,approved);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "RecommendationDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", kitchen='" + kitchen + '\'' +
                ", city='" + city + '\'' +
                ", foodName='" + foodName + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", message='" + message + '\'' +
                ", approved=" + approved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendationDto that = (RecommendationDto) o;
        return approved == that.approved && Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(kitchen, that.kitchen) && Objects.equals(city, that.city) && Objects.equals(foodName, that.foodName) && Objects.equals(restaurant, that.restaurant) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, kitchen, city, foodName, restaurant, message, approved);
    }
}
