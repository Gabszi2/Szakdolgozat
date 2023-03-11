package hu.uni.miskolc.s9njk6.foodchooser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends MongoRepository<FoodEntity,String> {
    //getAll
    @Query("{'town': ?0,'cuisine': ?1}")
    Iterable<FoodEntity> findAllByTownAndCuisine(String town,String cuisine);
    //get
    @Query("{'foodName': ?0,'town': ?1,'cuisine': ?2}")
    Optional<FoodEntity> findFoodEntityByFoodNameAndTownAndCuisine(String foodName, String town, String cuisine);
    //get recommendation
    @Query("{'answer': ?0,'town': ?1,'cuisine': ?2}")
    Optional<FoodEntity> findFoodEntityByAnswerAndTownAndCuisine(boolean[] answer,String town,String cuisine);

}
