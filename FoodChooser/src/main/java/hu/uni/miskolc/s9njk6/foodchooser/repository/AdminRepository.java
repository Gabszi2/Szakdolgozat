package hu.uni.miskolc.s9njk6.foodchooser.repository;

import java.util.List;

public interface AdminRepository {
    //update
    void saveFoodToTownAndKitchen(AnswerEntity answerEntity,String town,String kitchen);
    void saveQuestionsToKitchen(String oldQuestion,String newQuestion,String kitchen);
    //create
    void addFoodToTownAndKitchen(AnswerEntity answerEntity,String town,String kitchen);
    void addQuestionsToKitchen(String question,String kitchen);
    //delete
    void deleteFoodFromTownAndKitchen(AnswerEntity answerEntity,String town,String kitchen);
    void deleteQuestionFromKitchen(String question,String kitchen);
    //read
    List<AnswerEntity> findAllFoodFromTownAndKitchen(String town,String kitchen);
    QuestionsEntity getAllQuestionsFromKitchen(String kitchen);
}
