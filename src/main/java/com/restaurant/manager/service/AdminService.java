package com.restaurant.manager.service;

import com.restaurant.manager.entity.Restaurant;
import com.restaurant.manager.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant){
        Restaurant createdRestaurant = new Restaurant();
        createdRestaurant.setName(restaurant.getName());
        createdRestaurant.setStatus(restaurant.getStatus());
        createdRestaurant.setOpenTime(restaurant.getOpenTime());
        createdRestaurant.setCloseTime(restaurant.getCloseTime());
        createdRestaurant.setLocation(restaurant.getLocation());
        restaurantRepository.save(createdRestaurant);
        return createdRestaurant;
    }
}
