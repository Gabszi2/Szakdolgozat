package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.AdminService;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
//TODO szétszedni
@RestController
@RequestMapping("/admin")

public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    //Question Requests
    @GetMapping("/questions/{cuisine}")
   ResponseEntity< List<String>> allQuestions(@PathVariable("cuisine") String cuisine){
        List<String> out=new ArrayList<>();
        for (String s:adminService.allQuestions(cuisine)
             ) {
            out.add(s);
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    @DeleteMapping("/question/{cuisine}")
    void deleteQuestion(@RequestParam("question") String question,@PathVariable("cuisine")String cuisine){
        adminService.deleteQuestion(question, cuisine);
    }
    @PostMapping(value = "/question/{cuisine}")
    ResponseEntity<String> createQuestion(@RequestParam("question") String question,@PathVariable("cuisine") String cuisine) throws EntityAlreadyExistsException {
return new ResponseEntity<>(adminService.createQuestion(question, cuisine),HttpStatus.CREATED);
    }
    @PutMapping("question/{cuisine}")
    void saveQuestion(@RequestBody @Valid QuestionSaveDto questionSaveDto,@PathVariable("cuisine") String cuisine){
        adminService.saveQuestion(questionSaveDto.getOldQuestion(),questionSaveDto.getNewQuestion(),cuisine);
    }

    //Food Requests
    @GetMapping("/foods/{town}/{cuisine}")
    ResponseEntity<List<FoodDto>> allFood(@PathVariable("town") String town,@PathVariable("cuisine") String cuisine){
        List<FoodDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.FoodDto foodDto:adminService.allFood(town, cuisine)
             ) {
            out.add(new FoodDto(foodDto));
        }
        return new ResponseEntity<>(out,HttpStatus.OK);
    }
    @GetMapping("/food/{town}/{cuisine}/{foodName}")
    ResponseEntity<FoodDto> getFood(@PathVariable("town") String town,@PathVariable("cuisine") String cuisine,@PathVariable("foodName") String foodName){

        return new ResponseEntity<>(new FoodDto(adminService.getFood(town,cuisine,foodName)),HttpStatus.OK);
    }
    @DeleteMapping("/food/{town}/{cuisine}")
    void deleteFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("cuisine") String cuisine){
        adminService.deleteFood(foodDto.toServiceFoodDto(),town,cuisine);
    }
    @PostMapping(value = "/food/{town}/{cuisine}",consumes = "application/json")
    ResponseEntity<FoodDto> createFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("cuisine") String cuisine) throws EntityAlreadyExistsException {
        return new ResponseEntity<>(new FoodDto( adminService.createFood(foodDto.toServiceFoodDto(),town,cuisine)),HttpStatus.CREATED);
    }
@PutMapping("/food/{town}/{cuisine}")
    void saveFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("cuisine") String cuisine){
        adminService.saveFood(foodDto.toServiceFoodDto(),town,cuisine);
}
//Recommendation Requests
    @GetMapping("/recommendations")
    ResponseEntity<List<RecommendationDto>> allRecommendations(){
        List<RecommendationDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto recommendationDto:adminService.allRecommendations()){
            out.add(new RecommendationDto(recommendationDto));
        }
        return new ResponseEntity<>(out,HttpStatus.OK);
    }
    @GetMapping("/approved-recommendations")
    ResponseEntity<List<RecommendationDto>> allApprovedRecommendations(){
        List<RecommendationDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto recommendationDto:adminService.allApprovedRecommendation()){
            out.add(new RecommendationDto(recommendationDto));
        }
        return new ResponseEntity<>(out,HttpStatus.OK);
    }
    @GetMapping("/recommendation/{id}")
    ResponseEntity<RecommendationDto> getRecommendation(@PathVariable("id")Long id){
    return new ResponseEntity<>(new RecommendationDto(adminService.getRecommendation(id)),HttpStatus.OK);
    }
    @DeleteMapping("/recommendation/{id}")
    void deleteRecommendation(@PathVariable("id")Long id){
        adminService.deleteRecommendation(id);
    }
    @PutMapping("/recommendation/{id}")
    void updateApprovedRecommendation(@PathVariable("id")Long id){
        adminService.updateApproveRecommendation(id);
    }
    //User Requests
    @GetMapping("/users")
    ResponseEntity<List<UserDto>> allUsers(){
        List<UserDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.UserDto userDto: adminService.allUsers()){
            out.add(new UserDto(userDto));
        }
        return new ResponseEntity<>(out,HttpStatus.OK);
    }
    @DeleteMapping("/user/{email}/{password}")
    void deleteUser(@PathVariable("email") String email,@PathVariable("password")String password){
        adminService.deleteUser(email, password);
    }
    @PutMapping("/user/{email}/{password}")
    void updateAdminUser(@PathVariable("email") String email,@PathVariable("password")String password){
        adminService.updateAdminUser(email,password);
    }
    //City Requests
    @GetMapping(value = "/cities")
    ResponseEntity<List<CityDto>> allCities(){

        List<CityDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.CityDto cityDto: adminService.allCities()){
            out.add(new CityDto(cityDto));
        }
        return new ResponseEntity<>(out,HttpStatus.OK);
    }
    @GetMapping(value = "/city/{name}")
    ResponseEntity<CityDto> getCity(@PathVariable("name")String name){
        return new ResponseEntity<>(new CityDto(adminService.getCity(name)),HttpStatus.OK);
    }
    @DeleteMapping(value = "/city/{name}")
    void deleteCity(@PathVariable("name")String name){
        adminService.deleteCity(name);
    }
    @PostMapping(value = "/city",consumes = "application/json")
    ResponseEntity<CityDto> createCity(@RequestBody @Valid CityDto cityDto){
        return new ResponseEntity<>(new CityDto(adminService.createCity(cityDto.toServiceCityDto())),HttpStatus.CREATED);
    }
    @PutMapping(value = "/city")
    void updateCity(@RequestBody @Valid CityDto cityDto){
        adminService.updateCity(cityDto.toServiceCityDto());
    }
}
