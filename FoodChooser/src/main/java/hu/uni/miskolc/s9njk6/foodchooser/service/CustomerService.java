package hu.uni.miskolc.s9njk6.foodchooser.service;



public interface CustomerService {

    Iterable<String> allQuestions(String cuisine);
    FoodDto findFoodForRecommendation(boolean[] answers,String town,String cuisine);
    RecommendationDto createRecommendation(RecommendationDto recommendationDto);
    Iterable<CityDto> allCities();
}
