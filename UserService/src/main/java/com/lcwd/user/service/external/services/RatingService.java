package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    //GET

    //POST
    @PostMapping("/ratings")
    ResponseEntity<Ratings> createRating(Ratings rating);
    //PUT
    @PutMapping("ratings/{ratingId}")
    ResponseEntity<Ratings> updateRating(@PathVariable String ratingId, Ratings rating);
    //DELETE
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
