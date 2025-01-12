package com.lcwd.hotel.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping
    public ResponseEntity<List> getStaffs() {
       List<String> list= Arrays.asList("Ram","Shyam","Arun");
       return ResponseEntity.ok(list);
    }

}
