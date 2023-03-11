package hu.uni.miskolc.s9njk6.foodchooser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends MongoRepository<QuestionEntity,String> {
    //getAll
    @Query("{'cuisine': ?0}")
    Iterable<QuestionEntity> findAllByCuisine(String cuisine);
//get
        @Query("{'question': ?0,'cuisine': ?1}")
        Optional<QuestionEntity> findQuestionEntityByQuestionAndCuisine(String question, String cuisine);
}
