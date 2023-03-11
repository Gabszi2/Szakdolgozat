package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.*;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchFoodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final DataBaseRepository dataBaseRepository;

    RecommendationRepository recommendationRepository;
    public CustomerServiceImpl(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @Override
    public Iterable<String> allQuestions(String cuisine) {
        List<String> output=new ArrayList<>();
        for (QuestionEntity questionEntity:dataBaseRepository.getAllQuestionFromCuisine(cuisine)
        ) {
            output.add(questionEntity.getQuestion());
        }
        return output;
    }

    @Override
    public FoodDto findFoodForRecommendation(boolean[] customerAnswers, String town, String cuisine){
        List<FoodDto> allFoods=new ArrayList<>();
        FoodDto output=null;
        for (FoodEntity foodEntity:dataBaseRepository.getAllFoodFromTownAndCuisine(town, cuisine)
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

    @Override
    public RecommendationDto createRecommendation(RecommendationDto recommendationDto) {

           return new RecommendationDto(recommendationRepository.save(recommendationDto.toEntity()));

    }

    @Override
    public Iterable<CityDto> allCities() {
        List<CityDto> output=new ArrayList<>();
        for (CityEntity cityEntity:dataBaseRepository.getAllCities()
             ) {
            output.add(new CityDto(cityEntity));

        }
        return output;
    }
}
