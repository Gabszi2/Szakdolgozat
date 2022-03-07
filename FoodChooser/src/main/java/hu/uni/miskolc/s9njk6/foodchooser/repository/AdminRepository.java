package hu.uni.miskolc.s9njk6.foodchooser.repository;


import java.util.Collection;

public interface AdminRepository {

    //create
    void saveFoodToTownAndKitchen(AnswerEntity answerEntity, String town, String kitchen);
    void saveQuestionsToKitchen(QuestionEntity oldQuestion,QuestionEntity newQuestion, String kitchen);
    //delete
    void deleteFoodFromTownAndKitchen(AnswerEntity answerEntity,String town,String kitchen);
    void deleteQuestionFromKitchen(QuestionEntity question,String kitchen);
    //read
    Collection<AnswerEntity> getAllFoodFromTownAndKitchen(String town, String kitchen);
    Collection<QuestionEntity> getAllQuestionFromKitchen(String kitchen);
    AnswerEntity getFoodFromTownAndKitchen(String foodName,String town,String kitchen);
}
