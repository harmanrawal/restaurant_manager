package com.restaurant.manager.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="menu_items")
@Data
public class MenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_id", nullable = false)
    private Long restaurantId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    @Column(name = "price", nullable = false)
    private double price;
}
