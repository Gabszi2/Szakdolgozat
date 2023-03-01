package hu.uni.miskolc.s9njk6.foodchooser.controller;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Objects;

public class CityDto {
    @NotEmpty
    private String name;
    private String[] cuisines;

    public CityDto() {
    }

    public CityDto(hu.uni.miskolc.s9njk6.foodchooser.service.CityDto cityDto) {
        this.name = cityDto.getName();
        this.cuisines = cityDto.getCuisines();
    }
    public hu.uni.miskolc.s9njk6.foodchooser.service.CityDto toServiceCityDto(){return new hu.uni.miskolc.s9njk6.foodchooser.service.CityDto(name,cuisines);}

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
