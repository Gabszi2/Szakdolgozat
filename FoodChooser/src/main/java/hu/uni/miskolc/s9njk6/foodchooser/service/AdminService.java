package hu.uni.miskolc.s9njk6.foodchooser.service;


import java.util.Collection;

public interface AdminService {

    Iterable<String> allQuestions(String kitchen);
    void deleteQuestion(String question,String kitchen);
    String createQuestion(String question,String kitchen);
    void saveQuestion(String oldQuestion,String newQuestion,String kitchen);

    Collection<FoodDto> allFood(String town, String kitchen);
    FoodDto createFood(FoodDto foodDto, String town, String kitchen);
    void saveFood(FoodDto foodDto, String town, String kitchen);
    void deleteFood(FoodDto foodDto,String town,String kitchen);
    //TODO Food and question recommendations from costumers
}
