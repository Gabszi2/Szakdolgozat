package hu.uni.miskolc.s9njk6.foodchooser.repository;

public interface CostumerRepository {
    AnswerEntity foodFoundByAnswersInTownWithinKitchen(String town,String kitchen);
    QuestionEntity questionsForKitchen(String kitchen);

}
