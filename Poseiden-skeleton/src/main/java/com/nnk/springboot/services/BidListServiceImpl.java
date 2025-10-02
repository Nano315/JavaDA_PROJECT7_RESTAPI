package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class BidListServiceImpl implements BidListService {

    private final BidListRepository repository;

    public BidListServiceImpl(BidListRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BidList> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<BidList> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public BidList save(BidList bid) {
        return repository.save(bid);
    }

    @Override
    public BidList update(Integer id, BidList bid) {
        // vérifie l’existence
        BidList existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("BidList not found id=" + id));
        // on met à jour les champs principaux utilisés par l’UI
        existing.setAccount(bid.getAccount());
        existing.setType(bid.getType());
        existing.setBidQuantity(bid.getBidQuantity());
        return repository.save(existing);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
