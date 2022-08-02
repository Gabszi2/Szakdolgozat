package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.DataBaseRepository;

import hu.uni.miskolc.s9njk6.foodchooser.repository.UserEntity;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.springframework.stereotype.Service;



@Service
public class LoginServiceImpl implements LoginService {
    private final DataBaseRepository dataBaseRepository;

    public LoginServiceImpl(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    @Override
    public UserDto login(String email, String password) {
       UserEntity userEntity =dataBaseRepository.getUser(email,password);

        if (userEntity==null){
            throw new NoSuchEntityException(email);
        }
        return new UserDto(userEntity);


    }

    @Override
    public UserDto register(UserDto newUser) {
        UserEntity userEntity =dataBaseRepository.getUser(newUser.getEmail(),newUser.getPassword());

        if (userEntity==null){

          return new UserDto(dataBaseRepository.saveUser(newUser.toUserEntity()));
        }
        throw new EntityAlreadyExistsException(newUser.getEmail());

    }
}
