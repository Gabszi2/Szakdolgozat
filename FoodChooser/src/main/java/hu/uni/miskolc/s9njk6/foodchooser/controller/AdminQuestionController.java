package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.QuestionService;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminQuestionController {
    private final QuestionService questionService;

    public AdminQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions/{cuisine}")
    ResponseEntity<List<String>> allQuestions(@PathVariable("cuisine") String cuisine) {
        List<String> out = new ArrayList<>();
        for (String s : questionService.allQuestions(cuisine)
        ) {
            out.add(s);
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    @DeleteMapping("/question/{cuisine}")
    void deleteQuestion(@RequestParam("question") String question, @PathVariable("cuisine") String cuisine) {
        questionService.deleteQuestion(question, cuisine);
    }

    @PostMapping(value = "/question/{cuisine}")
    ResponseEntity<String> createQuestion(@RequestParam("question") String question, @PathVariable("cuisine") String cuisine) throws EntityAlreadyExistsException {
        return new ResponseEntity<>(questionService.createQuestion(question, cuisine), HttpStatus.CREATED);
    }

    @PutMapping("question/{cuisine}")
    void saveQuestion(@RequestBody @Valid QuestionSaveDto questionSaveDto, @PathVariable("cuisine") String cuisine) {
        questionService.saveQuestion(questionSaveDto.getOldQuestion(), questionSaveDto.getNewQuestion(), cuisine);
    }
}
