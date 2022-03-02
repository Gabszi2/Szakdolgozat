package hu.uni.miskolc.s9njk6.foodchooser.repository;


import java.util.Arrays;
import java.util.Objects;

public class AnswerEntity {
    private String foodName;
    private Boolean[] answers;
    private String[] restaurants;

    public AnswerEntity(String foodName, Boolean[] answers, String[] restaurants) {
        this.foodName = foodName;
        this.answers = answers;
        this.restaurants = restaurants;

    }

    public AnswerEntity() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Boolean[] getAnswers() {
        return answers;
    }

    public void setAnswers(Boolean[] answers) {
        this.answers = answers;
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
                ", answers=" + Arrays.toString(answers) +
                ", restaurants=" + Arrays.toString(restaurants) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity that = (AnswerEntity) o;
        return Objects.equals(foodName, that.foodName) && Arrays.equals(answers, that.answers) && Arrays.equals(restaurants, that.restaurants);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(foodName);
        result = 31 * result + Arrays.hashCode(answers);
        result = 31 * result + Arrays.hashCode(restaurants);
        return result;
    }
}
