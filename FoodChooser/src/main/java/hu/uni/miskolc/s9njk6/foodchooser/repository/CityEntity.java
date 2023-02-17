package hu.uni.miskolc.s9njk6.foodchooser.repository;

import java.util.Arrays;
import java.util.Objects;

public class CityEntity {
    private String name;
    private String[] kitchens;

    public CityEntity() {
    }

    public CityEntity(String name, String[] kitchens) {
        this.name = name;
        this.kitchens = kitchens;
    }

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
    public String toString() {
        return "CityEntity{" +
                "name='" + name + '\'' +
                ", kitchens=" + Arrays.toString(kitchens) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(name, that.name) && Arrays.equals(kitchens, that.kitchens);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(kitchens);
        return result;
    }
}
