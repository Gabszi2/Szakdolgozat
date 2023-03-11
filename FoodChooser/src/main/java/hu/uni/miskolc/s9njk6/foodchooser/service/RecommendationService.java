package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;

public interface RecommendationService {
    Iterable<RecommendationDto> allRecommendations();
    Iterable<RecommendationDto> allApprovedRecommendation();
    RecommendationDto getRecommendation(String id)throws NoSuchEntityException;
    RecommendationDto createRecommendation(RecommendationDto recommendationDto) ;
    void updateApproveRecommendation(String id)throws NoSuchEntityException;
    void deleteRecommendation(String id)throws NoSuchEntityException;

}
