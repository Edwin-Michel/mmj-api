package com.edmi.iot.controller;

import com.edmi.iot.dto.TemperatureDTO;
import com.edmi.iot.entity.Temperature;
import com.edmi.iot.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(value = "/temp")
public class TemperatureController {
    @Autowired
    private TemperatureService temperatureService;

    @GetMapping(value = "/{idTemp}")
    public ResponseEntity<TemperatureDTO> getHello(@PathVariable("idTemp") Long uuid){
        Temperature temp = temperatureService.findById(uuid);
        TemperatureDTO temperatureDTO = TemperatureDTO.builder()
                .label(temp.getLabel())
                .value(temp.getValue())
                .date(temp.getDate())
                .build();
        return new ResponseEntity<>(temperatureDTO, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<TemperatureDTO>> findAll(){
        List<Temperature> temps = temperatureService.findAll();
        List<TemperatureDTO> dtos = new ArrayList<>();
        temps.forEach( t ->{
            TemperatureDTO temperatureDTO = TemperatureDTO.builder()
                    .label(t.getLabel())
                    .value(t.getValue())
                    .date(t.getDate())
                    .build();
            dtos.add(temperatureDTO);
        });
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<TemperatureDTO> create(@RequestBody Temperature temp){
        Temperature response = temperatureService.create(temp);
        TemperatureDTO dto = TemperatureDTO.builder()
                .label(response.getLabel())
                .value(response.getValue())
                .date(response.getDate())
                .build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<TemperatureDTO> update(@RequestBody Temperature temp){
        Temperature response = temperatureService.update(temp);
        TemperatureDTO dto = TemperatureDTO.builder()
                .label(response.getLabel())
                .value(response.getValue())
                .date(response.getDate())
                .build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{idTemp}")
    public ResponseEntity<Boolean> delete(@PathVariable("idTemp") Long uuid){
        boolean response = temperatureService.delete(uuid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //@DeleteMapping(value = "/delete/All")
    @RequestMapping(value = "/deleteAll")
    public ResponseEntity<Boolean> eliminarTodos(){
        boolean response = temperatureService.eliminarTemps();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
