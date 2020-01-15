package com.github.ralmnsk.telbot.service;

import com.github.ralmnsk.telbot.data.CityRepository;
import com.github.ralmnsk.telbot.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@ComponentScan(basePackages = {"com.github.ralmnsk.telbot.model","com.github.ralmnsk.telbot.data"})
public class CityServiceDefault implements CityService {
    private CityRepository repo;

    @Autowired
    public CityServiceDefault(CityRepository repo) {
        this.repo = repo;
    }

    public CityServiceDefault() {
    }

    @Override
    public City create(City city) {
        City oldCity = repo.findByName(city.getName());
        if (oldCity==null){
            return repo.save(city);
        }
        return null;
    }

    @Override
    public City read(Long id) {
        Optional<City> byId =
                repo.findById(id);
        if(byId.isPresent()){
            City city = byId.get();
            return city;
        }
        return null;
    }

    @Override
    public City update(City city) {
        return repo.save(city);
    }

    @Override
    public City delete(Long id) {
        Optional<City> byId =
                repo.findById(id);
        if(byId.isPresent()){
            repo.deleteById(id);
            return byId.get();
        }
        return null;
    }

    @Override
    public City findByName(String name) {
        City city=repo.findByName(name);
        if(city!=null){
            return city;
        }
        return null;
    }

    @Override
    public List<City> findAll() {
        return repo.findAll();
    }
}
