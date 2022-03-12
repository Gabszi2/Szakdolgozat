package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.FoodEntity;

public class FoodDto {
    private Boolean[] answer;
    private String foodName;
    private String[] restaurants;

    public FoodDto() {
    }

    public FoodDto(Boolean[] answer, String foodName, String[] restaurants) {
        this.answer = answer;
        this.foodName = foodName;
        this.restaurants = restaurants;
    }
    public FoodDto(FoodEntity foodEntity) {
        this.answer = foodEntity.getAnswer();
        this.foodName = foodEntity.getFoodName();
        this.restaurants = foodEntity.getRestaurants();
    }
    public FoodEntity toEntity(){
        return new FoodEntity(foodName,answer,restaurants);
    }

    public Boolean[] getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean[] answer) {
        this.answer = answer;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String[] getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(String[] restaurants) {
        this.restaurants = restaurants;
    }
}
