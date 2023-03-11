package hu.uni.miskolc.s9njk6.foodchooser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {
    @Query("{'email': ?0,'password': ?1}")
    Optional<UserEntity> findUserEntityByEmailAndPassword(String email, String password);
}
