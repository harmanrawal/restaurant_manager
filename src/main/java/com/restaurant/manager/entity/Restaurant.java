package com.restaurant.manager.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Restaurants")
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(name = "open_time", nullable = false)
    private String openTime;

    @Column(name = "close_time", nullable = false)
    private String closeTime;

    @Column(nullable = false)
    private String status; // OPEN or CLOSED
}
