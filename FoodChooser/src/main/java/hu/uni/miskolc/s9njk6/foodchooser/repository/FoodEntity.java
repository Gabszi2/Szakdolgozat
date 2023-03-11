package hu.uni.miskolc.s9njk6.foodchooser.repository;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Objects;

@Document("Foods")
public class FoodEntity {
    @Id
    private String id;
    private boolean[] answer;
    private String foodName;
    private String[] restaurants;
    private String town;
    private String cuisine;

    public FoodEntity(String foodName, boolean[] answers, String[] restaurants, String town, String cuisine) {

        this.foodName = foodName;
        this.answer = answers;
        this.restaurants = restaurants;
        this.town = town;
        this.cuisine = cuisine;

    }

    public FoodEntity() {
    }

    @Override
    public String toString() {
        return "FoodEntity{" +
                "id='" + id + '\'' +
                ", answer=" + Arrays.toString(answer) +
                ", foodName='" + foodName + '\'' +
                ", restaurants=" + Arrays.toString(restaurants) +
                ", town='" + town + '\'' +
                ", cuisine='" + cuisine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodEntity that = (FoodEntity) o;
        return Objects.equals(id, that.id) && Arrays.equals(answer, that.answer) && Objects.equals(foodName, that.foodName) && Arrays.equals(restaurants, that.restaurants) && Objects.equals(town, that.town) && Objects.equals(cuisine, that.cuisine);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, foodName, town, cuisine);
        result = 31 * result + Arrays.hashCode(answer);
        result = 31 * result + Arrays.hashCode(restaurants);
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
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

}
