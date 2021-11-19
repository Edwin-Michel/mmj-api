package com.edmi.iot.repository;

import com.edmi.iot.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long> {

    @Modifying
    @Query(value = "DELETE FROM temperature temp WHERE temp.id > 0", nativeQuery = true)
    void eliminarTemperatura();

}
