package hu.uni.miskolc.s9njk6.foodchooser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<CityEntity,String> {
   /* @Query("{'name': ?0}")
    CityEntity findCityEntityByName(String name);*/
}
