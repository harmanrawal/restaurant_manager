package com.restaurant.manager.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tables")
@Data
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long table_id;

    @Column(name="restaurantId", nullable = false)
    private Long restaurantId;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "status", nullable = false)
    private String status;
}
