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
    public FoodDto findFoodForRecommendation(boolean[] customerAnswers, String town, String kitchen) throws NoSuchFoodException {

        for (FoodEntity foodEntity:dataBaseRepository.getAllFoodFromTownAndKitchen(town, kitchen)
        ) {
            if (foodEntity.getAnswer().equals(customerAnswers)){
                return new FoodDto(foodEntity);
            }
        }
        throw new NoSuchFoodException();

    }
}
