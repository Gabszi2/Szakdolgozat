package hu.uni.miskolc.s9njk6.foodchooser.service;


import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchFoodException;

public interface CustomerService {

    Iterable<String> allQuestions(String kitchen);
    FoodDto findFoodForRecommendation(boolean[] answers,String town,String kitchen) throws NoSuchFoodException;
    //TODO food and question recommendations from costumers
}
