package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminCityController {
    private final CityService cityService;

    public AdminCityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping(value = "/cities")
    ResponseEntity<List<CityDto>> allCities(){

        List<CityDto> out=new ArrayList<>();
        for (hu.uni.miskolc.s9njk6.foodchooser.service.CityDto cityDto: cityService.allCities()){
            out.add(new CityDto(cityDto));
        }
        return new ResponseEntity<>(out, HttpStatus.OK);
    }
    @GetMapping(value = "/city/{name}")
    ResponseEntity<CityDto> getCity(@PathVariable("name")String name){
        return new ResponseEntity<>(new CityDto(cityService.getCity(name)),HttpStatus.OK);
    }
    @DeleteMapping(value = "/city/{name}")
    void deleteCity(@PathVariable("name")String name){
        cityService.deleteCity(name);
    }
    @PostMapping(value = "/city",consumes = "application/json")
    ResponseEntity<CityDto> createCity(@RequestBody @Valid CityDto cityDto){
        return new ResponseEntity<>(new CityDto(cityService.createCity(cityDto.toServiceCityDto())),HttpStatus.CREATED);
    }
    @PutMapping(value = "/city")
    void updateCity(@RequestBody @Valid CityDto cityDto){
        cityService.updateCity(cityDto.toServiceCityDto());
    }
}
