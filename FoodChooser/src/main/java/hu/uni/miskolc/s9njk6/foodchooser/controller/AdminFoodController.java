package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.FoodService;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminFoodController {
    private final FoodService foodService;

    public AdminFoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods/{town}/{cuisine}")
    ResponseEntity<List<FoodDto>> allFood(@PathVariable("town") String town, @PathVariable("cuisine") String cuisine){
        List<FoodDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.FoodDto foodDto:foodService.allFood(town, cuisine)
        ) {
            out.add(new FoodDto(foodDto));
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }
    @GetMapping("/food/{town}/{cuisine}/{foodName}")
    ResponseEntity<FoodDto> getFood(@PathVariable("town") String town,@PathVariable("cuisine") String cuisine,@PathVariable("foodName") String foodName){

        return new ResponseEntity<>(new FoodDto(foodService.getFood(town,cuisine,foodName)),HttpStatus.OK);
    }
    @DeleteMapping("/food/{town}/{cuisine}")
    void deleteFood(@RequestBody @Valid FoodDto foodDto, @PathVariable("town") String town, @PathVariable("cuisine") String cuisine){
        foodService.deleteFood(foodDto.toServiceFoodDto(),town,cuisine);
    }
    @PostMapping(value = "/food/{town}/{cuisine}",consumes = "application/json")
    ResponseEntity<FoodDto> createFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("cuisine") String cuisine) throws EntityAlreadyExistsException {
        return new ResponseEntity<>(new FoodDto( foodService.createFood(foodDto.toServiceFoodDto(),town,cuisine)),HttpStatus.CREATED);
    }
    @PutMapping("/food/{town}/{cuisine}")
    void saveFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("cuisine") String cuisine){
        foodService.saveFood(foodDto.toServiceFoodDto(),town,cuisine);
}
}

