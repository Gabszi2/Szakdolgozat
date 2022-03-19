package hu.uni.miskolc.s9njk6.foodchooser.service;



public interface CostumerService {

    Iterable<String> allQuestion(String kitchen);
    FoodDto findFoodForRecommendation(FoodDto foodDto,String town,String kitchen);
    //TODO food and question recommendations from costumers
}
