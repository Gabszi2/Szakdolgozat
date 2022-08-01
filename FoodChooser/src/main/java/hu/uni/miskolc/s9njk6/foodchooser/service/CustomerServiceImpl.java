package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.DataBaseRepository;
import hu.uni.miskolc.s9njk6.foodchooser.repository.FoodEntity;
import hu.uni.miskolc.s9njk6.foodchooser.repository.QuestionEntity;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchFoodException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final DataBaseRepository dataBaseRepository;

    public CustomerServiceImpl(DataBaseRepository dataBaseRepository) {
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
    public FoodDto findFoodForRecommendation(boolean[] customerAnswers, String town, String kitchen){
        List<FoodDto> allFoods=new ArrayList<>();
        FoodDto output=null;
        for (FoodEntity foodEntity:dataBaseRepository.getAllFoodFromTownAndKitchen(town, kitchen)
        ) {
            allFoods.add(new FoodDto(foodEntity));

        }

       for (FoodDto food:allFoods){

            int good=0;

            for (int i=0;i<food.getAnswer().length;i++){
if (food.getAnswer()[i]==customerAnswers[i]){
                good++;}
            }

           if (good==food.getAnswer().length){
                output=food;
            }
        }

        if (output==null){
            throw new NoSuchFoodException();
        }
        return output;
    }
}
