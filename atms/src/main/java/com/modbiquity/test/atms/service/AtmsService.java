package com.modbiquity.test.atms.service;

import com.modbiquity.test.atms.data.AtmsInfo;

import java.util.List;

public interface AtmsService {

    List<AtmsInfo> getAtmsList();
    List<AtmsInfo> getAtmsByCity(String city);

}
