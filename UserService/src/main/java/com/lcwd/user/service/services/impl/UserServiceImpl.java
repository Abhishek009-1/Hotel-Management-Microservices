package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Ratings;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //generate unique user id
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        //implementing RATING SERVICE call: using REST Template
        return userRepository.findAll();
//        List getUsers=restTemplate.getForObject("http://localhost:8080/users", List.class);
//        logger.info(getUsers.toString());
//        return users;
    }

    //get single user
    @Override
    public User getUser(String userId) {
        //get user from database with the help of user repository
        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server "+userId)) ;
        //fetch rating above user from Rating service
        //http://localhost:8082/ratings/users/e30e9204-888d-4862-9051-875c7c10131c
      Ratings[] ratingsOfUser= restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Ratings[].class);
      logger.info(ratingsOfUser.toString());
      List<Ratings> ratings= Arrays.stream(ratingsOfUser).toList();
      List<Ratings> ratingsList = ratings.stream().map(rating -> {
          //api call to hotel service to get the hotel
          //http://localhost:8081/hotels/a90dd859-e85b-4ef1-baa9-069c990c640d
      //  ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
        Hotel hotel=hotelService.getHotel(rating.getHotelId());
      //  Hotel hotel = forEntity.getBody();
        // logger.info(hotel.toString());
          //set the hotel to rating
          rating.setHotel(hotel);
          //return the rating
          return rating;
      }).collect(Collectors.toList());

      user.setRatings(ratingsList);
      return user;
    }
}
