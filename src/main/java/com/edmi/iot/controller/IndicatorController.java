package com.edmi.iot.controller;

import com.edmi.iot.entity.Indicator;
import com.edmi.iot.service.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(value = "/ind")
public class IndicatorController {
    @Autowired
    private IndicatorService indicatorService;

    @GetMapping(value = "")
    public ResponseEntity<List<Indicator>> finaAll(){
        List<Indicator> indicators = indicatorService.finaAll();
        return new ResponseEntity<>(indicators, HttpStatus.OK);
    }

    @GetMapping(value = "/{idInd}")
    public ResponseEntity<Indicator> finById(@PathVariable("idInd") Long uuid){
        Indicator indicator = indicatorService.finById(uuid);
        return new ResponseEntity<>(indicator, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Indicator> create(@RequestBody Indicator ind){
        Indicator indicator = indicatorService.create(ind);
        return new ResponseEntity<>(indicator, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Indicator> update(@RequestBody Indicator indicator){
        Indicator response = indicatorService.update(indicator);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{idInd}")
    public ResponseEntity<Boolean> delete(@PathVariable("idInd") Long uuid){
        indicatorService.delete(uuid);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
