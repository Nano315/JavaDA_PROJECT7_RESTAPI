package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;

import java.util.List;
import java.util.Optional;

public interface TradeService {
    List<Trade> findAll();

    Optional<Trade> findById(Integer id);

    Trade save(Trade trade);

    Trade update(Integer id, Trade trade);

    void deleteById(Integer id);
}
