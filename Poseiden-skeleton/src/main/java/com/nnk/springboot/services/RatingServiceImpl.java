package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    private final RatingRepository repository;

    public RatingServiceImpl(RatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Rating> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Rating> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Rating save(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public Rating update(Integer id, Rating rating) {
        Rating existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rating not found id=" + id));
        existing.setMoodysRating(rating.getMoodysRating());
        existing.setSandPRating(rating.getSandPRating());
        existing.setFitchRating(rating.getFitchRating());
        existing.setOrderNumber(rating.getOrderNumber());
        return repository.save(existing);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
