package com.restaurant.manager.repository;

import com.restaurant.manager.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuItemEntity,Long> {
    List<MenuItemEntity> findByRestaurantId(Long restaurantId);
}
