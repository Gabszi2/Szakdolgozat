package hu.uni.miskolc.s9njk6.foodchooser.service;


import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;

public interface AdminService {

    Iterable<String> allQuestions(String kitchen);
    void deleteQuestion(String question,String kitchen);
    String createQuestion(String question,String kitchen) throws EntityAlreadyExistsException;
    void saveQuestion(String oldQuestion,String newQuestion,String kitchen);

    Iterable<FoodDto> allFood(String town, String kitchen);
    FoodDto getFood(String town,String kitchen,String foodName);
    FoodDto createFood(FoodDto foodDto, String town, String kitchen) throws EntityAlreadyExistsException;
    void saveFood(FoodDto foodDto, String town, String kitchen);
    void deleteFood(FoodDto foodDto,String town,String kitchen);


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
