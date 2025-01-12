package com.lcwd.rating.services;

import com.lcwd.rating.entities.Ratings;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    //create
    Ratings createRating(Ratings rating);
    //get all ratings
    List<Ratings> getAllRatings();
    //get all ratings by user id
    List<Ratings> getRatingsByUserId(String userId);
    //get all ratings by hotel id
    List<Ratings> getRatingsByHotelId(String hotelId);
}
