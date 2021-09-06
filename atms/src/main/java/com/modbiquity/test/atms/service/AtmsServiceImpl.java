package com.modbiquity.test.atms.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.modbiquity.test.atms.data.AtmsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtmsServiceImpl implements  AtmsService{

    @Autowired
    RestTemplate restTemplate;

    private  static final String url = "https://www.ing.nl/api/locator/atms/";

    @Override
    public List<AtmsInfo> getAtmsList() {
       return getAtmsInfo();
    }

    @Override
    public List<AtmsInfo> getAtmsByCity(String city) {
        List<AtmsInfo> atmsByCity = getAtmsInfo();
        List<AtmsInfo> atmsListByCity = atmsByCity.stream()
                .filter((atmByCity) -> atmByCity.getAddress().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        return atmsListByCity;
    }

    public List<AtmsInfo> getAtmsInfo(){
        List<AtmsInfo> atmsInfoList = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONPObject> entity = new HttpEntity<>(headers);
        ResponseEntity response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        }catch (HttpClientErrorException httpClientErrorException){
            System.out.println("client not avaiable");
        }catch (Exception e) {
            e.printStackTrace();
        }
        atmsInfoList = (List<AtmsInfo>)response.getBody();
        return  atmsInfoList;
    }
}
