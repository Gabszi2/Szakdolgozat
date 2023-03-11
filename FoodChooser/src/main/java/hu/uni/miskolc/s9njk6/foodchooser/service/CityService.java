package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;

public interface CityService {
    Iterable<CityDto> allCities();

    CityDto getCity(String name) throws NoSuchEntityException;

    CityDto createCity(CityDto cityDto) throws EntityAlreadyExistsException;

    void updateCity(CityDto cityDto) throws NoSuchEntityException;

    void deleteCity(String name) throws NoSuchEntityException;
}
