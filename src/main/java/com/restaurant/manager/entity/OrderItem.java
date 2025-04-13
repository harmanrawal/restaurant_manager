package com.restaurant.manager.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menu_item_id")
    private Long menuItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "served_units", nullable = false)
    private Integer servedUnits;

}
