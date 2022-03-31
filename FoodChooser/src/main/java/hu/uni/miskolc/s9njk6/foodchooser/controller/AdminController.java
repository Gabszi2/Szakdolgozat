package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.AdminService;
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
    //PathVariable-t a town és kitchen-hez
//Post-hoz application/json kell majd headerbe a cliens oldalon


    //Question Requests
    @GetMapping("/questions/{kitchen}")
    Iterable<String> allQuestions(@PathVariable("kitchen") String kitchen){
        List<String> out=new ArrayList<>();
        for (String s:adminService.allQuestions(kitchen)
             ) {
            out.add(s);
        }
        return out;
    }

    @DeleteMapping("/question/{kitchen}")
    void deleteQuestion(@RequestParam("question") String question,@PathVariable("kitchen")String kitchen){
        adminService.deleteQuestion(question, kitchen);
    }
    @PostMapping("/question/{kitchen}",consumes = "application/json")
    String createQuestion(@RequestParam("question") String question,@PathVariable("kitchen") String kitchen){
return adminService.createQuestion(question, kitchen);
    }
    @PutMapping("question/{kitchen}")
    void saveQuestion(@RequestBody @Valid QuestionSaveDto questionSaveDto,@PathVariable("kitchen") String kitchen){
        adminService.saveQuestion(questionSaveDto.getOldQuestion(),questionSaveDto.getNewQuestion(),kitchen);
    }

    //Food Requests
    @GetMapping("/foods/{town}/{kitchen}")
    Iterable<FoodDto> allFood(@PathVariable("town") String town,@PathVariable("kitchen") String kitchen){
        List<FoodDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.FoodDto foodDto:adminService.allFood(town, kitchen)
             ) {
            out.add(new FoodDto(foodDto));
        }
        return out;
    }
    @DeleteMapping("/food/{town}/{kitchen}")
    void deleteFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("kitchen") String kitchen){
        adminService.deleteFood(foodDto.toServiceFoodDto(),town,kitchen);
    }
    @PostMapping(value = "/food/{town}/{kitchen}",consumes = "application/json")
    FoodDto createFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("kitchen") String kitchen){
        return new FoodDto( adminService.createFood(foodDto.toServiceFoodDto(),town,kitchen));
    }
@PutMapping("/food/{town}/{kitchen}")
    void saveFood(@RequestBody @Valid FoodDto foodDto,@PathVariable("town") String town,@PathVariable("kitchen") String kitchen){
        adminService.saveFood(foodDto.toServiceFoodDto(),town,kitchen);
}
}
