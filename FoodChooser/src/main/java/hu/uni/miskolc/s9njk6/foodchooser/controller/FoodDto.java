package hu.uni.miskolc.s9njk6.foodchooser.controller;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;

public class FoodDto {
    @NotEmpty
    private boolean[] answer;
    @NotEmpty
    private String foodName;
    @NotEmpty
    private String[] restaurants;

    public FoodDto() {
    }

    public FoodDto(hu.uni.miskolc.s9njk6.foodchooser.service.FoodDto foodDto) {
        this.answer = foodDto.getAnswer();
        this.foodName = foodDto.getFoodName();
        this.restaurants = foodDto.getRestaurants();
    }
    public hu.uni.miskolc.s9njk6.foodchooser.service.FoodDto toServiceFoodDto(){
    return new hu.uni.miskolc.s9njk6.foodchooser.service.FoodDto(answer,foodName,restaurants);
    }
    public boolean[] getAnswer() {
        return answer;
    }

    public void setAnswer(boolean[] answer) {
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

    @Override
    public String toString() {
        return "FoodOutDto{" +
                "answer=" + Arrays.toString(answer) +
                ", foodName='" + foodName + '\'' +
                ", restaurants=" + Arrays.toString(restaurants) +
                '}';
    }
}
