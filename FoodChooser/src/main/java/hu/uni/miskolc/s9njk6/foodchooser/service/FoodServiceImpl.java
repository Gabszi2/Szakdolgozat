package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.FoodEntity;
import hu.uni.miskolc.s9njk6.foodchooser.repository.FoodRepository;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchFoodException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Iterable<FoodDto> allFood(String town, String cuisine) {
        List<FoodDto> output = new ArrayList<>();
        for (FoodEntity foodEntity : foodRepository.findAllByTownAndCuisine(town, cuisine)
        ) {
            output.add(new FoodDto(foodEntity));
        }
        return output;
    }

    @Override
    public FoodDto getFood(String town, String cuisine, String foodName) throws NoSuchEntityException {
        Optional<FoodEntity> searched = foodRepository.findFoodEntityByFoodNameAndTownAndCuisine(foodName, town, cuisine);
        if (searched.isEmpty()) {
            throw new NoSuchEntityException(foodName);
        }
        return new FoodDto(searched.get());
    }

    @Override
    public FoodDto getFoodRecommendation(boolean[] answers, String town, String cuisine) throws NoSuchFoodException {
        Optional<FoodEntity> searched = foodRepository.findFoodEntityByAnswerAndTownAndCuisine(answers, town, cuisine);
        if (searched.isEmpty()) {
            throw new NoSuchFoodException();
        }
        return new FoodDto(searched.get());
    }

    @Override
    public FoodDto createFood(FoodDto foodDto, String town, String cuisine) throws EntityAlreadyExistsException {
        Optional<FoodEntity> searched = foodRepository.findFoodEntityByFoodNameAndTownAndCuisine(foodDto.getFoodName(), town, cuisine);
        if (searched.isEmpty()) {

            FoodEntity output = foodDto.toEntity();
            output.setCuisine(cuisine);
            output.setTown(town);
            return new FoodDto(foodRepository.save(output));
        }
        throw new EntityAlreadyExistsException(foodDto.getFoodName());
    }

    @Override
    public void saveFood(FoodDto foodDto, String town, String cuisine) throws NoSuchEntityException {
        Optional<FoodEntity> searched = foodRepository.findFoodEntityByFoodNameAndTownAndCuisine(foodDto.getFoodName(), town, cuisine);
        if (searched.isEmpty()) {
            throw new NoSuchEntityException(foodDto.getFoodName());
        }
        FoodEntity output = foodDto.toEntity();
        output.setId(searched.get().getId());
        output.setCuisine(cuisine);
        output.setTown(town);
        foodRepository.save(output);
    }

    @Override
    public void deleteFood(FoodDto foodDto, String town, String cuisine) throws NoSuchEntityException {
        Optional<FoodEntity> searched = foodRepository.findFoodEntityByFoodNameAndTownAndCuisine(foodDto.getFoodName(), town, cuisine);
        if (searched.isEmpty()) {
            throw new NoSuchEntityException(foodDto.getFoodName());
        }
        foodRepository.deleteById(searched.get().getId());
    }
}
