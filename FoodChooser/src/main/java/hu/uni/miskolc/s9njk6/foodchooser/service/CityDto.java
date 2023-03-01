package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.CityEntity;

import java.util.Arrays;
import java.util.Objects;

public class CityDto {
    private String name;
    private String[] cuisines;

    public CityDto() {
    }

    public CityDto(String name, String[] cuisines) {
        this.name = name;
        this.cuisines = cuisines;
    }
    public CityDto(CityEntity cityEntity) {
        this.name = cityEntity.getName();
        this.cuisines = cityEntity.getCuisines();
    }
    public CityEntity toEntity(){return new CityEntity(name,cuisines);}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCuisines() {
        return cuisines;
    }

    public void setCuisines(String[] cuisines) {
        this.cuisines = cuisines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return Objects.equals(name, cityDto.name) && Arrays.equals(cuisines, cityDto.cuisines);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(cuisines);
        return result;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "name='" + name + '\'' +
                ", cuisines=" + Arrays.toString(cuisines) +
                '}';
    }
}
