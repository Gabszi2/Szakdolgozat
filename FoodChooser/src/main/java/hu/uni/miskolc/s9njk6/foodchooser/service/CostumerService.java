package hu.uni.miskolc.s9njk6.foodchooser.service;

import java.util.Collection;

public interface CostumerService {

    String[] allQuestion(String kitchen);
    FoodDto findFoodForRecommendation(FoodDto foodDto,String town,String kitchen);
    //TODO food and question recommendations from costumers
}
