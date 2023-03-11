package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRecommendationController {
    private final RecommendationService recommendationService;

    public AdminRecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendations")
    ResponseEntity<List<RecommendationDto>> allRecommendations() {
        List<RecommendationDto> out = new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto recommendationDto : recommendationService.allRecommendations()) {
            out.add(new RecommendationDto(recommendationDto));
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    @GetMapping("/approved-recommendations")
    ResponseEntity<List<RecommendationDto>> allApprovedRecommendations() {
        List<RecommendationDto> out = new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.RecommendationDto recommendationDto : recommendationService.allApprovedRecommendation()) {
            out.add(new RecommendationDto(recommendationDto));
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }

    @GetMapping("/recommendation/{id}")
    ResponseEntity<RecommendationDto> getRecommendation(@PathVariable("id") String id) {
        return new ResponseEntity<>(new RecommendationDto(recommendationService.getRecommendation(id)), HttpStatus.OK);
    }

    @DeleteMapping("/recommendation/{id}")
    void deleteRecommendation(@PathVariable("id") String id) {
        recommendationService.deleteRecommendation(id);
    }

    @PutMapping("/recommendation/{id}")
    void updateApprovedRecommendation(@PathVariable("id") String id) {
        recommendationService.updateApproveRecommendation(id);
    }
}
