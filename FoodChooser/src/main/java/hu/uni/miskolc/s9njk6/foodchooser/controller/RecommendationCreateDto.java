package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class RecommendationCreateDto {
    @NotEmpty
    private String type;
    private String cuisine;
    private String city;
    private String foodName;
    private String restaurant;
    @NotEmpty
    private String message;
    private boolean approved;

    public RecommendationCreateDto() {
    }

    public RecommendationCreateDto(RecommendationDto recommendationDto) {
        this.type = recommendationDto.getType();
        this.cuisine = recommendationDto.getCuisine();
        this.city = recommendationDto.getCity();
        this.foodName = recommendationDto.getFoodName();
        this.restaurant = recommendationDto.getRestaurant();
        this.message = recommendationDto.getMessage();
        this.approved = recommendationDto.isApproved();
    }

    public RecommendationDto toServiceRecommendationDto() {
        return new RecommendationDto(null, type, cuisine, city, foodName, restaurant, message, approved);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
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
        return "RecommendationCreateDto{" +
                "type='" + type + '\'' +
                ", cuisine='" + cuisine + '\'' +
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
        RecommendationCreateDto that = (RecommendationCreateDto) o;
        return approved == that.approved && Objects.equals(type, that.type) && Objects.equals(cuisine, that.cuisine) && Objects.equals(city, that.city) && Objects.equals(foodName, that.foodName) && Objects.equals(restaurant, that.restaurant) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, cuisine, city, foodName, restaurant, message, approved);
    }
}
