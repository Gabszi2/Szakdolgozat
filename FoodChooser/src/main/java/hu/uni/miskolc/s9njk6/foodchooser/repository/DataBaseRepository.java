package hu.uni.miskolc.s9njk6.foodchooser.repository;


import java.util.Collection;


public interface DataBaseRepository {

    //create
    FoodEntity saveFoodToTownAndCuisine(FoodEntity foodEntity, String town, String cuisine);
    QuestionEntity saveQuestionsToCuisine(QuestionEntity oldQuestion,QuestionEntity newQuestion, String cuisine);
    UserEntity saveUser(UserEntity userEntity);
    RecommendationEntity saveRecommendation(RecommendationEntity recommendationEntity);
    CityEntity saveCity(CityEntity cityEntity);
    //delete
    void deleteFoodFromTownAndCuisine(FoodEntity foodEntity, String town, String cuisine);
    void deleteQuestionFromCuisine(QuestionEntity question,String cuisine);
    void deleteUser(String email);
    void deleteRecommendation(Long id);
    void deleteCity(String name);
    //read
    Collection<FoodEntity> getAllFoodFromTownAndCuisine(String town, String cuisine);
    Collection<QuestionEntity> getAllQuestionFromCuisine(String cuisine);
    Collection<UserEntity> getAllUser();
    Collection<RecommendationEntity> getAllRecommendations(boolean approved);
    Collection<CityEntity> getAllCities();

    FoodEntity getFoodFromTownAndCuisine(String foodName, String town, String cuisine);
    QuestionEntity getQuestionFromCuisine(String question, String cuisine);
    UserEntity getUser(String email,String password);
    RecommendationEntity getRecommendation(Long id);
    CityEntity getCity(String name);



}
