package com.restaurant.manager.repository;

import com.restaurant.manager.entity.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, Long> {
    List<TableEntity> findByRestaurantId(Long restaurantId);
}
