package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchFoodException;

public interface FoodService {
    Iterable<FoodDto> allFood(String town, String cuisine);

    FoodDto getFood(String town, String cuisine, String foodName) throws NoSuchEntityException;

    FoodDto getFoodRecommendation(boolean[] answers, String town, String cuisine) throws NoSuchFoodException;

    FoodDto createFood(FoodDto foodDto, String town, String cuisine) throws EntityAlreadyExistsException;

    void saveFood(FoodDto foodDto, String town, String cuisine) throws NoSuchEntityException;

    void deleteFood(FoodDto foodDto, String town, String cuisine) throws NoSuchEntityException;
}
