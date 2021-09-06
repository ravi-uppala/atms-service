package com.modbiquity.test.atms.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.modbiquity.test.atms.data.AtmsInfo;
import com.modbiquity.test.atms.service.AtmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AtmsRestController {

    @Autowired
    AtmsService atmService;

    @GetMapping(value = "/atmlist", produces = "application/json")
    @ResponseBody
    public ResponseEntity getListOfAtms(){
        List<AtmsInfo> atmList = atmService.getAtmsList();
        if(atmList!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(atmList);
        else
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(atmList);
    }

    @GetMapping(value = "/atmlist/{city}", produces = "application/json")
    @ResponseBody
    public ResponseEntity getAtmsByCity(@PathVariable("city") String city){
        List<AtmsInfo> atmListByCity = atmService.getAtmsByCity(city);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(atmListByCity);
    }
}
