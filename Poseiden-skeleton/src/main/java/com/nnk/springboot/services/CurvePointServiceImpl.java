package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class CurvePointServiceImpl implements CurvePointService {

    private final CurvePointRepository repository;

    public CurvePointServiceImpl(CurvePointRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CurvePoint> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CurvePoint> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public CurvePoint save(CurvePoint cp) {
        return repository.save(cp);
    }

    @Override
    public CurvePoint update(Integer id, CurvePoint cp) {
        CurvePoint existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("CurvePoint not found id=" + id));

        existing.setTerm(cp.getTerm());
        existing.setValue(cp.getValue());
        existing.setCurveId(cp.getCurveId());
        existing.setAsOfDate(cp.getAsOfDate());
        existing.setCreationDate(cp.getCreationDate());

        return repository.save(existing);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
