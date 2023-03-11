package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.RecommendationEntity;

import java.util.Objects;

public class RecommendationDto {

    private String id;
    private String type;
    private String cuisine;
    private String city;
    private String foodName;
    private String restaurant;
    private String message;
    private boolean approved;

    public RecommendationDto() {
    }

    public RecommendationDto(String id, String type, String cuisine, String city, String foodName, String restaurant, String message, boolean approved) {
        this.id = id;
        this.type = type;
        this.cuisine = cuisine;
        this.city = city;
        this.foodName = foodName;
        this.restaurant = restaurant;
        this.message = message;
        this.approved = approved;
    }

    public RecommendationDto(RecommendationEntity recommendationEntity) {
        this.id = recommendationEntity.getId();
        this.type = recommendationEntity.getType();
        this.cuisine = recommendationEntity.getCuisine();
        this.city = recommendationEntity.getCity();
        this.foodName = recommendationEntity.getFoodName();
        this.restaurant = recommendationEntity.getRestaurant();
        this.message = recommendationEntity.getMessage();
        this.approved = recommendationEntity.isApproved();
    }

    public RecommendationEntity toEntity() {
        return new RecommendationEntity(id, type, cuisine, city, foodName, restaurant, message, approved);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "RecommendationDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
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
        RecommendationDto that = (RecommendationDto) o;
        return approved == that.approved && Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(cuisine, that.cuisine) && Objects.equals(city, that.city) && Objects.equals(foodName, that.foodName) && Objects.equals(restaurant, that.restaurant) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, cuisine, city, foodName, restaurant, message, approved);
    }
}
