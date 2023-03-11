package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.RecommendationEntity;
import hu.uni.miskolc.s9njk6.foodchooser.repository.RecommendationRepository;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    private final RecommendationRepository recommendationRepository;

    public RecommendationServiceImpl(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public Iterable<RecommendationDto> allRecommendations() {
        List<RecommendationDto> output = new ArrayList<>();
        for (RecommendationEntity recommendation : recommendationRepository.findAll()
        ) {
            output.add(new RecommendationDto(recommendation));
        }

        return output;
    }

    @Override
    public Iterable<RecommendationDto> allApprovedRecommendation() {
        List<RecommendationDto> output = new ArrayList<>();
        for (RecommendationEntity recommendation : recommendationRepository.findAllByApproved()
        ) {
            output.add(new RecommendationDto(recommendation));
        }

        return output;
    }

    @Override
    public RecommendationDto getRecommendation(String id) throws NoSuchEntityException {
        Optional<RecommendationEntity> searched = recommendationRepository.findById(id);
        if (searched.isEmpty()) {
            throw new NoSuchEntityException(id);
        }
        return new RecommendationDto(searched.get());
    }

    @Override
    public RecommendationDto createRecommendation(RecommendationDto recommendationDto) {

        return new RecommendationDto(recommendationRepository.save(recommendationDto.toEntity()));
    }

    @Override
    public void updateApproveRecommendation(String id) throws NoSuchEntityException {
        Optional<RecommendationEntity> searched = recommendationRepository.findById(id);
        if (searched.isEmpty()) {
            throw new NoSuchEntityException(id);
        }
        searched.get().setApproved(!searched.get().isApproved());
        recommendationRepository.save(searched.get());

    }

    @Override
    public void deleteRecommendation(String id) throws NoSuchEntityException {
        Optional<RecommendationEntity> searched = recommendationRepository.findById(id);
        if (searched.isEmpty()) {
            throw new NoSuchEntityException(id);
        }
        recommendationRepository.deleteById(id);
    }
}
