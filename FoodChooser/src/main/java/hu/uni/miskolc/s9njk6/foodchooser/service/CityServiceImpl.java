package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.CityEntity;
import hu.uni.miskolc.s9njk6.foodchooser.repository.CityRepository;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Iterable<CityDto> allCities() {
        List<CityDto> output=new ArrayList<>();
        for (CityEntity cityEntity:cityRepository.findAll()
             ) {
output.add(new CityDto(cityEntity));
        }
        return output;
    }

    @Override
    public CityDto getCity(String name) throws NoSuchEntityException {
        Optional<CityEntity> searched=cityRepository.findById(name);
        if (searched.isEmpty()){
            throw new NoSuchEntityException(name);
        }

        return new CityDto(searched.get());
    }

    @Override
    public CityDto createCity(CityDto cityDto) throws EntityAlreadyExistsException {
        Optional<CityEntity> searched=cityRepository.findById(cityDto.getName());
        if (searched.isEmpty()){
            return new CityDto(cityRepository.save(cityDto.toEntity()));
        }
        throw new EntityAlreadyExistsException(cityDto.getName());
    }

    @Override
    public void updateCity(CityDto cityDto)throws NoSuchEntityException {
Optional<CityEntity> searched=cityRepository.findById(cityDto.getName());
if (searched.isEmpty()){
    throw new NoSuchEntityException(cityDto.getName());
}
cityRepository.save(cityDto.toEntity());

    }

    @Override
    public void deleteCity(String name) throws NoSuchEntityException{
        Optional<CityEntity> searched=cityRepository.findById(name);
        if (searched.isEmpty()){
            throw new NoSuchEntityException(name);
        }
        cityRepository.deleteById(name);
    }
}
