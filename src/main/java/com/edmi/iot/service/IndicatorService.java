package com.edmi.iot.service;

import com.edmi.iot.entity.Indicator;
import com.edmi.iot.repository.IndicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndicatorService {
    @Autowired
    private IndicatorRepository indicatorRepository;

    public List<Indicator> finaAll(){
        List<Indicator> indicators = new ArrayList<>();
        indicators = indicatorRepository.findAll();
        return indicators;
    }

    public Indicator finById(Long uuid){
        Indicator indicator = indicatorRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("El valor no existe"));
        return indicator;
    }

    @Transactional
    public Indicator create(Indicator ind){
        Indicator indicator = Indicator.builder()
                .status(ind.getStatus())
                .build();
        Indicator response = indicatorRepository.save(indicator);
        return response;
    }

    @Transactional
    public Indicator update(Indicator indicator){
        Indicator exists = indicatorRepository.findById(indicator.getId())
                .orElseThrow(() -> new RuntimeException("El valor no existe"));
        exists.setStatus(indicator.getStatus());
        Indicator response = indicatorRepository.save(exists);
        return response;
    }

    @Transactional
    public void delete(Long uuid){
        Indicator indicator = indicatorRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("El valor no existe"));
        indicatorRepository.delete(indicator);
    }
}
