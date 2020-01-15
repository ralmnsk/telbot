package com.github.ralmnsk.telbot.service;

import com.github.ralmnsk.telbot.model.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface CityService {
    City create(City city);
    City read(Long id);
    City update(City city);
    City delete(Long id);
    City findByName(String name);
    List<City> findAll();
}
