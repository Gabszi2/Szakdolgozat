package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.CityService;
import hu.uni.miskolc.s9njk6.foodchooser.service.FoodService;
import hu.uni.miskolc.s9njk6.foodchooser.service.QuestionService;
import hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationService;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchFoodException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
private final QuestionService questionService;
private final FoodService foodService;
private final RecommendationService recommendationService;
private final CityService cityService;

    public CustomerController(QuestionService questionService, FoodService foodService, RecommendationService recommendationService, CityService cityService) {
        this.questionService = questionService;
        this.foodService = foodService;
        this.recommendationService = recommendationService;
        this.cityService = cityService;
    }

    @GetMapping("/customer-questions/{cuisine}")
    ResponseEntity<List<String>> allQuestions(@PathVariable("cuisine") String cuisine){
        List<String> out=new ArrayList<>();
        for (String s:questionService.allQuestions(cuisine)
        ) {
            out.add(s);
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }
    @GetMapping("/result/{town}/{cuisine}")
    ResponseEntity<FoodDto> result(@PathVariable("town") String town, @PathVariable("cuisine") String cuisine, @RequestParam("answers") boolean[] answers) throws NoSuchFoodException {
        return new ResponseEntity<>(new FoodDto(foodService.getFoodRecommendation(answers,town,cuisine)),HttpStatus.OK);

    }
    @PostMapping(value = "/customer-recommendation",consumes = "application/json")
    ResponseEntity<RecommendationDto> createRecommendation(@RequestBody @Valid RecommendationCreateDto recommendationCreateDto)throws EntityAlreadyExistsException {
        return new ResponseEntity<>(new RecommendationDto(recommendationService.createRecommendation(recommendationCreateDto.toServiceRecommendationDto())),HttpStatus.CREATED);
    }
    @GetMapping(value = "/cities")
    ResponseEntity<List<CityDto>> allCities(){
        List<CityDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.CityDto cityDto: cityService.allCities()){
            out.add(new CityDto(cityDto));
        }
        return new ResponseEntity<>(out,HttpStatus.OK);
    }
}
