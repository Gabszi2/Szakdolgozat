package hu.uni.miskolc.s9njk6.foodchooser.service;



public interface CustomerService {

    Iterable<String> allQuestions(String kitchen);
    FoodDto findFoodForRecommendation(boolean[] answers,String town,String kitchen);
    RecommendationDto createRecommendation(RecommendationDto recommendationDto);
    Iterable<CityDto> allCities();
}
