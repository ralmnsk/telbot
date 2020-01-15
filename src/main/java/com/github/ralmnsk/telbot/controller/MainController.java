package com.github.ralmnsk.telbot.controller;

import com.github.ralmnsk.telbot.model.City;
import com.github.ralmnsk.telbot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class MainController {
    @Autowired
    private CityService cityService;

    @GetMapping(value="")
    public ResponseEntity<List<City>> getCities(){
        List<City> list=cityService.findAll();
        if (list.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") Long id){
        City city=cityService.read(id);
        if (city == null) { return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping(value="")//1
    public ResponseEntity<City> addCity(@RequestBody City city){
        City newCity=cityService.create(city);
        if (newCity == null) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<City> updateCity(
            @PathVariable("id") Long id,
            @RequestBody City newCity){
        City city=cityService.read(id);
        if (city == null) { return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        city.setName(newCity.getName());
        city.setInfo(newCity.getInfo());
        newCity=cityService.update(city);
        return new ResponseEntity(newCity, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<City> deleteCity(@PathVariable("id")Long id){
        City city=cityService.delete(id);
        if (city == null) { return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        return new ResponseEntity(city,HttpStatus.OK);
    }
}
