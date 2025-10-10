package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    List<Rating> findAll();

    Optional<Rating> findById(Integer id);

    Rating save(Rating rating);

    Rating update(Integer id, Rating rating);

    void deleteById(Integer id);
}
