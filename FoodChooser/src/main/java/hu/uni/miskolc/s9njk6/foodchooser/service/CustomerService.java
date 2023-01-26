package hu.uni.miskolc.s9njk6.foodchooser.service;



public interface CustomerService {

    Iterable<String> allQuestions(String kitchen);
    FoodDto findFoodForRecommendation(boolean[] answers,String town,String kitchen);
    //TODO food and question recommendations from costumers
    RecommendationDto createRecommendation(RecommendationDto recommendationDto);
}
