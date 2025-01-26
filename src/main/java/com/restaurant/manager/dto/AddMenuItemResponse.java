package com.restaurant.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddMenuItemResponse {
    private boolean success;
    private Long menuItemId;
    private String name;
}
