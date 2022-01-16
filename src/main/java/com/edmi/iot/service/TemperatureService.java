package com.edmi.iot.service;

import com.edmi.iot.entity.Temperature;
import com.edmi.iot.repository.TemperatureRepository;
import com.edmi.iot.util.DateFormatt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class TemperatureService {
    private final TemperatureRepository temperatureRepository;

    @Autowired
    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public Temperature findById(Long uuid){
        Temperature existsTemp = temperatureRepository.findById(uuid)
                .orElseThrow(()-> new RuntimeException("El valor no existe"));
        return existsTemp;
    }

    public List<Temperature> findAll(){
        List<Temperature> temps = temperatureRepository.findAll();
        return temps;
    }

    @Transactional
    public Temperature create(Temperature temp){
        Temperature createTemp = Temperature.builder()
                .label(temp.getLabel())
                .value(temp.getValue())
                .date(DateFormatt.getDate(new Date()))
                .build();
        Temperature temperature = temperatureRepository.save(createTemp);
        return temperature;
    }

    @Transactional
    public Temperature update(Temperature temperature){
        Temperature exists = temperatureRepository.findById(temperature.getId())
                .orElseThrow(() -> new RuntimeException("El valor no existe"));
        exists.setLabel(temperature.getLabel());
        exists.setValue(temperature.getValue());
        exists.setDate(DateFormatt.getDate(new Date()));
        Temperature temp = temperatureRepository.save(exists);
        return temp;
    }

    @Transactional
    public boolean delete(Long uuid){
        Temperature exists = temperatureRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("El valor no existe"));
        temperatureRepository.delete(exists);
        return true;
    }

    @Transactional
    public boolean eliminarTemps(){
        temperatureRepository.eliminarTemperatura();
        return true;
    }
}
