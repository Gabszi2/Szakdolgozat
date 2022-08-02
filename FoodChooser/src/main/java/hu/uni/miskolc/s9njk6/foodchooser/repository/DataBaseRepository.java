package hu.uni.miskolc.s9njk6.foodchooser.repository;


import java.util.Collection;


public interface DataBaseRepository {

    //create
    FoodEntity saveFoodToTownAndKitchen(FoodEntity foodEntity, String town, String kitchen);
    QuestionEntity saveQuestionsToKitchen(QuestionEntity oldQuestion,QuestionEntity newQuestion, String kitchen);
    UserEntity saveUser(UserEntity userEntity);
    //delete
    void deleteFoodFromTownAndKitchen(FoodEntity foodEntity, String town, String kitchen);
    void deleteQuestionFromKitchen(QuestionEntity question,String kitchen);
    void deleteUser(UserEntity userEntity);
    //read
    Collection<FoodEntity> getAllFoodFromTownAndKitchen(String town, String kitchen);
    Collection<QuestionEntity> getAllQuestionFromKitchen(String kitchen);
    Collection<UserEntity> getAllUser();
    FoodEntity getFoodFromTownAndKitchen(String foodName, String town, String kitchen);
    QuestionEntity getQuestionFromKitchen(String question, String kitchen);
    UserEntity getUser(String email);

    //TODO food and question recommendations from costumers
    //TODO login user database
}
