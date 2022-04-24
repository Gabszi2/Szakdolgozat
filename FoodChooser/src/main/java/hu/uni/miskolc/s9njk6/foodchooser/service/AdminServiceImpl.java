package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.DataBaseRepository;
import hu.uni.miskolc.s9njk6.foodchooser.repository.FoodEntity;
import hu.uni.miskolc.s9njk6.foodchooser.repository.QuestionEntity;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final DataBaseRepository dataBaseRepository;

    public AdminServiceImpl(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @Override
    public Iterable<String> allQuestions(String kitchen) {
        List<String> output=new ArrayList<>();
        for (QuestionEntity questionEntity:dataBaseRepository.getAllQuestionFromKitchen(kitchen)
             ) {
            output.add(questionEntity.getQuestion());
        }


        return output;
    }

    @Override
    public void deleteQuestion(String question, String kitchen) {
        QuestionEntity questionEntity=dataBaseRepository.getQuestionFromKitchen(question, kitchen);

        if (questionEntity==null){
            throw new NoSuchEntityException(question);
        }
        dataBaseRepository.deleteQuestionFromKitchen(questionEntity,kitchen);
    }

    @Override
    public String createQuestion(String question, String kitchen) {
        return dataBaseRepository.saveQuestionsToKitchen(new QuestionEntity(question),new QuestionEntity(question),kitchen).getQuestion();
    }

    @Override
    public void saveQuestion(String oldQuestion, String newQuestion, String kitchen) {
        QuestionEntity searched=dataBaseRepository.getQuestionFromKitchen(oldQuestion,kitchen);
        if (searched==null){
            throw new NoSuchEntityException(oldQuestion);
        }
        dataBaseRepository.saveQuestionsToKitchen(new QuestionEntity(oldQuestion),new QuestionEntity(newQuestion),kitchen);
    }

    @Override
    public Iterable<FoodDto> allFood(String town, String kitchen) {
        List<FoodDto> output=new ArrayList<>();
        for (FoodEntity foodEntity:dataBaseRepository.getAllFoodFromTownAndKitchen(town, kitchen)
             ) {
            output.add(new FoodDto(foodEntity));
        }
        return output;
    }
    @Override
    public FoodDto getFood(String town, String kitchen,String foodName){
        FoodEntity foodEntity=dataBaseRepository.getFoodFromTownAndKitchen(foodName,town,kitchen);
        if (foodEntity==null){
            throw new NoSuchEntityException(foodName);
        }
        return new FoodDto(foodEntity) ;
    }
    @Override
    public FoodDto createFood(FoodDto foodDto, String town, String kitchen) {
        return new FoodDto(dataBaseRepository.saveFoodToTownAndKitchen(foodDto.toEntity(),town,kitchen));
    }

    @Override
    public void saveFood(FoodDto foodDto, String town, String kitchen) {
        FoodEntity searched=dataBaseRepository.getFoodFromTownAndKitchen(foodDto.getFoodName(), town,kitchen);
        if (searched==null){
            throw new NoSuchEntityException(foodDto.getFoodName());
        }
        dataBaseRepository.saveFoodToTownAndKitchen(foodDto.toEntity(),town,kitchen);
    }

    @Override
    public void deleteFood(FoodDto foodDto, String town, String kitchen) {
        FoodEntity searched=dataBaseRepository.getFoodFromTownAndKitchen(foodDto.getFoodName(), town,kitchen);
        if (searched==null){
            throw new NoSuchEntityException(foodDto.getFoodName());
        }
        dataBaseRepository.deleteFoodFromTownAndKitchen(foodDto.toEntity(),town,kitchen);
    }
}
