package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.FoodEntity;

import java.util.Arrays;
import java.util.Objects;

public class FoodDto {
    private boolean[] answer;
    private String foodName;
    private String[] restaurants;

    public FoodDto() {
    }

    public FoodDto(boolean[] answer, String foodName, String[] restaurants) {
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
        return new FoodEntity(foodName,answer,restaurants,null,null);
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
        return "FoodDto{" +
                "answer=" + Arrays.toString(answer) +
                ", foodName='" + foodName + '\'' +
                ", restaurants=" + Arrays.toString(restaurants) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodDto foodDto = (FoodDto) o;
        return Arrays.equals(answer, foodDto.answer) && Objects.equals(foodName, foodDto.foodName) && Arrays.equals(restaurants, foodDto.restaurants);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(foodName);
        result = 31 * result + Arrays.hashCode(answer);
        result = 31 * result + Arrays.hashCode(restaurants);
        return result;
    }
}
