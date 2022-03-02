package hu.uni.miskolc.s9njk6.foodchooser.repository;


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


}
