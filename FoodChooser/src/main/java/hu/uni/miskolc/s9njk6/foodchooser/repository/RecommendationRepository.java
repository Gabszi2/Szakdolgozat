package hu.uni.miskolc.s9njk6.foodchooser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RecommendationRepository extends MongoRepository<RecommendationEntity, String> {
    @Query("{'approved': true}")
    Collection<RecommendationEntity> findAllByApproved();
}
