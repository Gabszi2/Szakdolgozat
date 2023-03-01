package hu.uni.miskolc.s9njk6.foodchooser.repository;

import java.util.Arrays;
import java.util.Objects;

public class CityEntity {
    private String name;
    private String[] cuisines;

    public CityEntity() {
    }

    public CityEntity(String name, String[] cuisines) {
        this.name = name;
        this.cuisines = cuisines;
    }

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
    public String toString() {
        return "CityEntity{" +
                "name='" + name + '\'' +
                ", cuisines=" + Arrays.toString(cuisines) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(name, that.name) && Arrays.equals(cuisines, that.cuisines);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(cuisines);
        return result;
    }
}
