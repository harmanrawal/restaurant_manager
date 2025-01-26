package com.restaurant.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddMenuItemRequest {
    @JsonProperty("restaurantId")
    private Long restaurantId;
    private String name;
    private String description;
    private String category;
    private boolean availability;
    private double price;
}
