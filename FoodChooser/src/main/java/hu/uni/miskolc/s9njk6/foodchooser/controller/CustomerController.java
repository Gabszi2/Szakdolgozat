package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.CustomerService;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchFoodException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
