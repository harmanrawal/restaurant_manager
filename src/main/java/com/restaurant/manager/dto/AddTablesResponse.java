package com.restaurant.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddTablesResponse {
    private boolean success;
    private List<Long> tableIds;
}
