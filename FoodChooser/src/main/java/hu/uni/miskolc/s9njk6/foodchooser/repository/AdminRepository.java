package hu.uni.miskolc.s9njk6.foodchooser.repository;

import java.util.List;

public interface AdminRepository {
    void saveFoodToTownAndKitchen(AnswerEntity answerEntity,String town,String kitchen);//+create(added to file)
    void saveQuestionsToKitchen(QuestionsEntity questionsEntity,String kitchen);//+create(added to file)
    void deleteFoodFromTownAndKitchen(AnswerEntity answerEntity,String town,String kitchen);
    void deleteQuestionFromKitchen(QuestionsEntity questionsEntity,String kitchen);
    List<AnswerEntity> findAllFoodFromTownAndKitchen(String town,String kitchen);
    QuestionsEntity getAllQuestionsFromKitchen(String kitchen);
}
