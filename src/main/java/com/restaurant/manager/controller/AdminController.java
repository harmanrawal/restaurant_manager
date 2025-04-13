package com.restaurant.manager.controller;

import com.restaurant.manager.entity.Restaurant;
import com.restaurant.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/createRestaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        Restaurant createdRestaurant = adminService.createRestaurant(restaurant);
        return createdRestaurant;
    }
}
