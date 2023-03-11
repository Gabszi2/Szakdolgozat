package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.UserEntity;
import hu.uni.miskolc.s9njk6.foodchooser.repository.UserRepository;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<UserDto> allUsers() {
        List<UserDto> output=new ArrayList<>();
        for (UserEntity userEntity: userRepository.findAll()
             ) {
            output.add(new UserDto(userEntity));
        }
        return output;
    }

    @Override
    public void updateAdminUser(String email, String password)throws NoSuchEntityException {
        Optional<UserEntity> searched=userRepository.findUserEntityByEmailAndPassword(email, password);
        if (searched.isEmpty()){
            throw new NoSuchEntityException(email);
        }
        searched.get().setAdmin(!searched.get().isAdmin());
        userRepository.save(searched.get());

    }

    @Override
    public void deleteUser(String email, String password)throws NoSuchEntityException {
        Optional<UserEntity> searched=userRepository.findUserEntityByEmailAndPassword(email, password);
        if (searched.isEmpty()){
            throw new NoSuchEntityException(email);
        }
        userRepository.deleteById(email);

    }
}
