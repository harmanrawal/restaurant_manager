package com.restaurant.manager.dto;

import lombok.Data;

@Data
public class AddTablesRequest {
    private Long restaurantId;
    private int quantity;
    private int maxCapacity;
}