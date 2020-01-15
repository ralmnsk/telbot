package com.github.ralmnsk.telbot.data;

import com.github.ralmnsk.telbot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    @Query("select c from City c where c.name = :name")
    City findByName(@Param("name") String name);
}
