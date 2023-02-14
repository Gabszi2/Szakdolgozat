package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class RecommendationCreateDto {
    @NotEmpty
    private String type;
    private String kitchen;
    private String city;
    private String restaurant;
    @NotEmpty
    private String message;
    private boolean approved;

    public RecommendationCreateDto() {
    }

    public RecommendationCreateDto(RecommendationDto recommendationDto) {
        this.type = recommendationDto.getType();
        this.kitchen =recommendationDto.getKitchen();
        this.city = recommendationDto.getCity();
        this.restaurant = recommendationDto.getRestaurant();
        this.message = recommendationDto.getMessage();
        this.approved = recommendationDto.isApproved();
    }
    public RecommendationDto toServiceRecommendationDto(){
        return new RecommendationDto(null,type,kitchen,city,restaurant,message,approved);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendationCreateDto that = (RecommendationCreateDto) o;
        return approved == that.approved && Objects.equals(type, that.type) && Objects.equals(kitchen, that.kitchen) && Objects.equals(city, that.city) && Objects.equals(restaurant, that.restaurant) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, kitchen, city, restaurant, message, approved);
    }

    @Override
    public String toString() {
        return "RecommendationCreateDto{" +
                "type='" + type + '\'' +
                ", kitchen='" + kitchen + '\'' +
                ", city='" + city + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", message='" + message + '\'' +
                ", approved=" + approved +
                '}';
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
