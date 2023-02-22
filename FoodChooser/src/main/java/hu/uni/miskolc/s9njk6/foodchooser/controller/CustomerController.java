package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.CustomerService;
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
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customer-questions/{kitchen}")
    ResponseEntity<List<String>> allQuestions(@PathVariable("kitchen") String kitchen){
        List<String> out=new ArrayList<>();
        for (String s:customerService.allQuestions(kitchen)
        ) {
            out.add(s);
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }
    @GetMapping("/result/{town}/{kitchen}")
    ResponseEntity<FoodDto> result(@PathVariable("town") String town, @PathVariable("kitchen") String kitchen, @RequestParam("answers") boolean[] answers) throws NoSuchFoodException {
        return new ResponseEntity<>(new FoodDto(customerService.findFoodForRecommendation(answers,town,kitchen)),HttpStatus.OK);

    }
    @PostMapping(value = "/customer-recommendation",consumes = "application/json")
    ResponseEntity<RecommendationDto> createRecommendation(@RequestBody @Valid RecommendationCreateDto recommendationCreateDto)throws EntityAlreadyExistsException {
        return new ResponseEntity<>(new RecommendationDto(customerService.createRecommendation(recommendationCreateDto.toServiceRecommendationDto())),HttpStatus.CREATED);
    }
    @GetMapping(value = "/cities")
    ResponseEntity<List<CityDto>> allCities(){
        List<CityDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.CityDto cityDto: customerService.allCities()){
            out.add(new CityDto(cityDto));
        }
        return new ResponseEntity<>(out,HttpStatus.OK);
    }
}
