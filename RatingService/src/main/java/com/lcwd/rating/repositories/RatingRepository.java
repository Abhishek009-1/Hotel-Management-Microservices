package com.lcwd.rating.repositories;

import com.lcwd.rating.entities.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Ratings,String> {

    //custom finder methods
    List<Ratings> findByUserId(String userId);
    List<Ratings> findByHotelId(String hotelId);
}
