package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.*;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {
    private final DataBaseRepository dataBaseRepository;

    public AdminServiceImpl(DataBaseRepository dataBaseRepository) {
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
    public void deleteQuestion(String question, String cuisine) {
        QuestionEntity questionEntity=dataBaseRepository.getQuestionFromCuisine(question, cuisine);

        if (questionEntity==null){
            throw new NoSuchEntityException(question);
        }
        dataBaseRepository.deleteQuestionFromCuisine(questionEntity,cuisine);
    }

    @Override
    public String createQuestion(String question, String cuisine) throws EntityAlreadyExistsException {
        QuestionEntity questionEntity=dataBaseRepository.getQuestionFromCuisine(question, cuisine);

        if (questionEntity==null){

            return dataBaseRepository.saveQuestionsToCuisine(new QuestionEntity(question),new QuestionEntity(question),cuisine).getQuestion();
        }
        throw new EntityAlreadyExistsException(question);
    }

    @Override
    public void saveQuestion(String oldQuestion, String newQuestion, String cuisine) {
        QuestionEntity searched=dataBaseRepository.getQuestionFromCuisine(oldQuestion,cuisine);
        if (searched==null){
            throw new NoSuchEntityException(oldQuestion);
        }
        dataBaseRepository.saveQuestionsToCuisine(new QuestionEntity(oldQuestion),new QuestionEntity(newQuestion),cuisine);
    }

    @Override
    public Iterable<FoodDto> allFood(String town, String cuisine) {
        List<FoodDto> output=new ArrayList<>();
        for (FoodEntity foodEntity:dataBaseRepository.getAllFoodFromTownAndCuisine(town, cuisine)
             ) {
            output.add(new FoodDto(foodEntity));
        }
        return output;
    }
    @Override
    public FoodDto getFood(String town, String cuisine,String foodName){
        FoodEntity foodEntity=dataBaseRepository.getFoodFromTownAndCuisine(foodName,town,cuisine);
        if (foodEntity==null){
            throw new NoSuchEntityException(foodName);
        }
        return new FoodDto(foodEntity) ;
    }
    @Override
    public FoodDto createFood(FoodDto foodDto, String town, String cuisine) throws EntityAlreadyExistsException {
        FoodEntity foodEntity=dataBaseRepository.getFoodFromTownAndCuisine(foodDto.getFoodName(),town,cuisine);
        if(foodEntity==null){
            return new FoodDto(dataBaseRepository.saveFoodToTownAndCuisine(foodDto.toEntity(),town,cuisine));
        }
       throw new EntityAlreadyExistsException(foodDto.getFoodName());
    }

    @Override
    public void saveFood(FoodDto foodDto, String town, String cuisine) {
        FoodEntity searched=dataBaseRepository.getFoodFromTownAndCuisine(foodDto.getFoodName(), town,cuisine);
        if (searched==null){
            throw new NoSuchEntityException(foodDto.getFoodName());
        }
        dataBaseRepository.saveFoodToTownAndCuisine(foodDto.toEntity(),town,cuisine);
    }

    @Override
    public void deleteFood(FoodDto foodDto, String town, String cuisine) {
        FoodEntity searched=dataBaseRepository.getFoodFromTownAndCuisine(foodDto.getFoodName(), town,cuisine);
        if (searched==null){
            throw new NoSuchEntityException(foodDto.getFoodName());
        }
        dataBaseRepository.deleteFoodFromTownAndCuisine(foodDto.toEntity(),town,cuisine);
    }

    @Override
    public Iterable<RecommendationDto> allRecommendations() {
        List<RecommendationDto> output=new ArrayList<>();
        for (RecommendationEntity recommendationEntity:dataBaseRepository.getAllRecommendations(false)
             ) {
            output.add(new RecommendationDto(recommendationEntity));
        }
        return output;
    }

    @Override
    public Iterable<RecommendationDto> allApprovedRecommendation() {
        List<RecommendationDto> output=new ArrayList<>();
        for (RecommendationEntity recommendationEntity:dataBaseRepository.getAllRecommendations(true)
        ) {
            output.add(new RecommendationDto(recommendationEntity));
        }
        return output;
    }

    @Override
    public RecommendationDto getRecommendation(Long id) {
        RecommendationEntity recommendationEntity=dataBaseRepository.getRecommendation(id);
        if (recommendationEntity==null){
            throw new NoSuchEntityException(String.valueOf(id));
        }return new RecommendationDto(recommendationEntity);

    }

    @Override
    public void updateApproveRecommendation(Long id) {
        RecommendationEntity searched=dataBaseRepository.getRecommendation(id);
        if (searched==null){
            throw new NoSuchEntityException(String.valueOf(id));
        }
        searched.setApproved(!searched.isApproved());
        dataBaseRepository.saveRecommendation(searched);

    }

    @Override
    public void deleteRecommendation(Long id) {
        RecommendationEntity searched=dataBaseRepository.getRecommendation(id);
        if (searched==null){
            throw new NoSuchEntityException(String.valueOf(id));
        }
        dataBaseRepository.deleteRecommendation(id);

    }

    @Override
    public Iterable<UserDto> allUsers() {
        List<UserDto> output=new ArrayList<>();
        for (UserEntity userEntity:dataBaseRepository.getAllUser()){
            output.add(new UserDto(userEntity));
        }
        return output;
    }

    @Override
    public void updateAdminUser(String email, String password) {
        UserEntity searched=dataBaseRepository.getUser(email, password);
        if (searched==null){
            throw new NoSuchEntityException(email);
        }
        searched.setAdmin(!searched.isAdmin());
        dataBaseRepository.saveUser(searched);

    }

    @Override
    public void deleteUser(String email, String password) {
        UserEntity searched=dataBaseRepository.getUser(email, password);
        if (searched==null){
            throw new NoSuchEntityException(email);
        }
        dataBaseRepository.deleteUser(email);
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
    @Override
    public void deleteCity(String name) {
        CityEntity cityEntity=dataBaseRepository.getCity(name);
        if (cityEntity==null){
            throw new NoSuchEntityException(name);
        }
        dataBaseRepository.deleteCity(name);
    }

    @Override
    public CityDto getCity(String name) {
        CityEntity cityEntity=dataBaseRepository.getCity(name);
        if (cityEntity==null){
            throw new NoSuchEntityException(name);
        }
        return new CityDto(cityEntity);
    }

    @Override
    public CityDto createCity(CityDto cityDto) throws EntityAlreadyExistsException {
        CityEntity cityEntity=dataBaseRepository.getCity(cityDto.getName());
        if (cityEntity==null){
            return new CityDto(dataBaseRepository.saveCity(cityDto.toEntity()));
        }
        throw new EntityAlreadyExistsException(cityDto.getName());
    }

    @Override
    public void updateCity(CityDto cityDto) {
        CityEntity cityEntity=dataBaseRepository.getCity(cityDto.getName());
        if (cityEntity==null){
            throw new NoSuchEntityException(cityDto.getName());
        }
        dataBaseRepository.saveCity(cityDto.toEntity());
    }
}
