package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class RuleNameServiceImpl implements RuleNameService {

    private final RuleNameRepository repository;

    public RuleNameServiceImpl(RuleNameRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RuleName> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<RuleName> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public RuleName save(RuleName rule) {
        return repository.save(rule);
    }

    @Override
    public RuleName update(Integer id, RuleName rule) {
        RuleName existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("RuleName not found id=" + id));
        existing.setName(rule.getName());
        existing.setDescription(rule.getDescription());
        existing.setJson(rule.getJson());
        existing.setTemplate(rule.getTemplate());
        existing.setSqlStr(rule.getSqlStr());
        existing.setSqlPart(rule.getSqlPart());
        return repository.save(existing);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
