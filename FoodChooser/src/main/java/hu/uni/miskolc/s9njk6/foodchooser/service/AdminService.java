package hu.uni.miskolc.s9njk6.foodchooser.service;


import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;

public interface AdminService {

    Iterable<String> allQuestions(String cuisine);
    void deleteQuestion(String question,String cuisine);
    String createQuestion(String question,String cuisine) throws EntityAlreadyExistsException;
    void saveQuestion(String oldQuestion,String newQuestion,String cuisine);

    Iterable<FoodDto> allFood(String town, String cuisine);
    FoodDto getFood(String town,String cuisine,String foodName);
    FoodDto createFood(FoodDto foodDto, String town, String cuisine) throws EntityAlreadyExistsException;
    void saveFood(FoodDto foodDto, String town, String cuisine);
    void deleteFood(FoodDto foodDto,String town,String cuisine);


    Iterable<RecommendationDto> allRecommendations();
    Iterable<RecommendationDto> allApprovedRecommendation();
    RecommendationDto getRecommendation(Long id);
    void updateApproveRecommendation(Long id);
    void deleteRecommendation(Long id);

    Iterable<UserDto> allUsers();
    void updateAdminUser(String email,String password);
    void deleteUser(String email,String password);

    Iterable<CityDto> allCities();
    CityDto getCity(String name);
    CityDto createCity(CityDto cityDto) throws EntityAlreadyExistsException;
    void updateCity(CityDto cityDto);
    void deleteCity(String name);

}
