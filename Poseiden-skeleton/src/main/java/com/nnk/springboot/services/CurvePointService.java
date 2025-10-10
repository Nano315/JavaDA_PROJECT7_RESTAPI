package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;
import java.util.Optional;

public interface CurvePointService {
    List<CurvePoint> findAll();

    Optional<CurvePoint> findById(Integer id);

    CurvePoint save(CurvePoint cp);

    CurvePoint update(Integer id, CurvePoint cp);

    void deleteById(Integer id);
}
