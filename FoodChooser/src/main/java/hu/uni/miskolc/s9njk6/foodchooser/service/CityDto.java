package hu.uni.miskolc.s9njk6.foodchooser.service;

import hu.uni.miskolc.s9njk6.foodchooser.repository.CityEntity;

import java.util.Arrays;
import java.util.Objects;

public class CityDto {
    private String name;
    private String[] kitchens;

    public CityDto() {
    }

    public CityDto(String name, String[] kitchens) {
        this.name = name;
        this.kitchens = kitchens;
    }
    public CityDto(CityEntity cityEntity) {
        this.name = cityEntity.getName();
        this.kitchens = cityEntity.getKitchens();
    }
    public CityEntity toEntity(){return new CityEntity(name,kitchens);}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getKitchens() {
        return kitchens;
    }

    public void setKitchens(String[] kitchens) {
        this.kitchens = kitchens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return Objects.equals(name, cityDto.name) && Arrays.equals(kitchens, cityDto.kitchens);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(kitchens);
        return result;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "name='" + name + '\'' +
                ", kitchens=" + Arrays.toString(kitchens) +
                '}';
    }
}
