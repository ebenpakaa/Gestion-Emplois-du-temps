package com.example.emploidutemps.services;

import com.example.emploidutemps.dto.CoursDTO;
import com.example.emploidutemps.models.Cour;
import com.example.emploidutemps.services.baseService.BaseServiceInterface;

public interface CourService extends BaseServiceInterface<Cour,Long> {

    CoursDTO save(CoursDTO coursDTO);
}
