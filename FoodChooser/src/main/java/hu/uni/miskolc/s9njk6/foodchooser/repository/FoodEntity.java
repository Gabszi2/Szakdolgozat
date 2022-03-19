package hu.uni.miskolc.s9njk6.foodchooser.repository;


import java.util.Arrays;
import java.util.Objects;

public class FoodEntity {
    private boolean[] answer;
    private String foodName;
    private String[] restaurants;

    public FoodEntity(String foodName, boolean[] answers, String[] restaurants) {
        this.foodName = foodName;
        this.answer = answers;
        this.restaurants = restaurants;

    }

    public FoodEntity() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public boolean[] getAnswer() {
        return answer;
    }

    public void setAnswer(boolean[] answer) {
        this.answer = answer;
    }

    public String[] getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(String[] restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public String toString() {
        return "AnswerEntity{" +
                "foodName='" + foodName + '\'' +
                ", answers=" + Arrays.toString(answer) +
                ", restaurants=" + Arrays.toString(restaurants) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodEntity that = (FoodEntity) o;
        return Objects.equals(foodName, that.foodName) && Arrays.equals(answer, that.answer) && Arrays.equals(restaurants, that.restaurants);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(foodName);
        result = 31 * result + Arrays.hashCode(answer);
        result = 31 * result + Arrays.hashCode(restaurants);
        return result;
    }
}
