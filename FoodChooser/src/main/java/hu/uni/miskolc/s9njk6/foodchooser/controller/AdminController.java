package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.AdminService;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")

public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    //Question Requests
    @GetMapping("/questions/{kitchen}")
   ResponseEntity< List<String>> allQuestions(@PathVariable("kitchen") String kitchen){
        List<String> out=new ArrayList<>();
        for (String s:adminService.allQuestions(kitchen)
             ) {
            out.add(s);
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    @DeleteMapping("/question/{kitchen}")
    void deleteQuestion(@RequestParam("question") String question,@PathVariable("kitchen")String kitchen){
        adminService.deleteQuestion(question, kitchen);
    }
    @PostMapping(value = "/question/{kitchen}")
    ResponseEntity<String> createQuestion(@RequestParam("question") String question,@PathVariable("kitchen") String kitchen) throws EntityAlreadyExistsException {
return new ResponseEntity<>(adminService.createQuestion(question, kitchen),HttpStatus.CREATED);
    }
    @PutMapping("question/{kitchen}")
    void saveQuestion(@RequestBody @Valid QuestionSaveDto questionSaveDto,@PathVariable("kitchen") String kitchen){
        adminService.saveQuestion(questionSaveDto.getOldQuestion(),questionSaveDto.getNewQuestion(),kitchen);
    }

    //Food Requests
    @GetMapping("/foods/{town}/{kitchen}")
    ResponseEntity<List<FoodDto>> allFood(@PathVariable("town") String town,@PathVariable("kitchen") String kitchen){
        List<FoodDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.FoodDto foodDto:adminService.allFood(town, kitchen)
             ) {
            out.add(new FoodDto(foodDto));
        }
        return new ResponseEntity<>(out,HttpStatus.OK);
    }
    @GetMapping("/food/{town}/{kitchen}/{foodName}")
    ResponseEntity<FoodDto> getFood(@PathVariable("town") String town,@PathVariable("kitchen") String kitchen,@PathVariable("foodName") String foodName){

        return new ResponseEntity<>(new FoodDto(adminService.getFood(town,kitchen,foodName)),HttpStatus.OK);
    }
    @DeleteMapping("/food/{town}/{kitchen}")
    void deleteFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("kitchen") String kitchen){
        adminService.deleteFood(foodDto.toServiceFoodDto(),town,kitchen);
    }
    @PostMapping(value = "/food/{town}/{kitchen}",consumes = "application/json")
    ResponseEntity<FoodDto> createFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("kitchen") String kitchen) throws EntityAlreadyExistsException {
        return new ResponseEntity<>(new FoodDto( adminService.createFood(foodDto.toServiceFoodDto(),town,kitchen)),HttpStatus.CREATED);
    }
@PutMapping("/food/{town}/{kitchen}")
    void saveFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("kitchen") String kitchen){
        adminService.saveFood(foodDto.toServiceFoodDto(),town,kitchen);
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
    @PutMapping(value = "city")
    void updateCity(@RequestBody @Valid CityDto cityDto){
        adminService.updateCity(cityDto.toServiceCityDto());
    }
}
