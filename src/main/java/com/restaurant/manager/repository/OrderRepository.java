package com.restaurant.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.restaurant.manager.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByRestaurantId(Long restaurantId);
    List<Order> findByTableId(Long tableId);
}
