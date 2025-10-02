package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;

import java.util.List;
import java.util.Optional;

public interface BidListService {
    List<BidList> findAll();

    Optional<BidList> findById(Integer id);

    BidList save(BidList bid);

    BidList update(Integer id, BidList bid);

    void deleteById(Integer id);
}
