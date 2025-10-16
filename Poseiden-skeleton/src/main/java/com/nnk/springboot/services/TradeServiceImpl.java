package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class TradeServiceImpl implements TradeService {

    private final TradeRepository repository;

    public TradeServiceImpl(TradeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Trade> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Trade> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Trade save(Trade trade) {
        return repository.save(trade);
    }

    @Override
    public Trade update(Integer id, Trade trade) {
        Trade existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Trade not found id=" + id));

        existing.setAccount(trade.getAccount());
        existing.setType(trade.getType());
        existing.setBuyQuantity(trade.getBuyQuantity());
        existing.setSellQuantity(trade.getSellQuantity());
        existing.setBuyPrice(trade.getBuyPrice());
        existing.setSellPrice(trade.getSellPrice());
        existing.setTradeDate(trade.getTradeDate());
        existing.setSecurity(trade.getSecurity());
        existing.setStatus(trade.getStatus());
        existing.setTrader(trade.getTrader());
        existing.setBenchmark(trade.getBenchmark());
        existing.setBook(trade.getBook());
        existing.setCreationName(trade.getCreationName());
        existing.setCreationDate(trade.getCreationDate());
        existing.setRevisionName(trade.getRevisionName());
        existing.setRevisionDate(trade.getRevisionDate());
        existing.setDealName(trade.getDealName());
        existing.setDealType(trade.getDealType());
        existing.setSourceListId(trade.getSourceListId());
        existing.setSide(trade.getSide());

        return repository.save(existing);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
