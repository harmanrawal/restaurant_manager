package com.restaurant.manager.repository;

import com.restaurant.manager.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    boolean existsById(Long restaurantId);
}
