package com.example.emploidutemps.services;

import com.example.emploidutemps.dto.EmploiDTO;
import com.example.emploidutemps.models.EmploiTemp;
import com.example.emploidutemps.services.baseService.BaseServiceInterface;

public interface EmploiTempService extends BaseServiceInterface<EmploiTemp,Long> {

    EmploiTemp save(EmploiDTO emploiTemp);
}
