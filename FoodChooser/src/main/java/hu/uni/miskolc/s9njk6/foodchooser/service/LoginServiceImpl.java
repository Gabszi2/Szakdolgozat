package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.UserEntity;
import hu.uni.miskolc.s9njk6.foodchooser.repository.UserRepository;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto login(String email, String password) throws NoSuchEntityException {
        Optional<UserEntity> searched = userRepository.findUserEntityByEmailAndPassword(email, password);

        if (searched.isEmpty()) {
            throw new NoSuchEntityException(email);
        }
        return new UserDto(searched.get());


    }

    @Override
    public UserDto register(UserDto newUser) throws EntityAlreadyExistsException {
        Optional<UserEntity> searched = userRepository.findById(newUser.getEmail());

        if (searched.isEmpty()) {

            return new UserDto(userRepository.save(newUser.toEntity()));
        }
        throw new EntityAlreadyExistsException(newUser.getEmail());

    }
}
