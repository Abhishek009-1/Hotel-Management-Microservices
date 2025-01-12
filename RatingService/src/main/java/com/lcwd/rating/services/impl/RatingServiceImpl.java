package com.lcwd.rating.services.impl;

import com.lcwd.rating.entities.Ratings;
import com.lcwd.rating.repositories.RatingRepository;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public Ratings createRating(Ratings rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
