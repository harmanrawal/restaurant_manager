package com.restaurant.manager.controller;

import com.restaurant.manager.dto.AddTablesRequest;
import com.restaurant.manager.dto.AddTablesResponse;
import com.restaurant.manager.service.ManagerService;
import com.restaurant.manager.entity.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/restaurant/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @PostMapping("/addTables")
    public AddTablesResponse addTables(@RequestBody AddTablesRequest request){
        AddTablesResponse response = managerService.addTables(request);
        return response;
    }

    @GetMapping("/tables/{restaurantId}")
    public ResponseEntity<List<TableEntity>> getTablesForRestaurant(@PathVariable Long restaurantId) {
        List<TableEntity> tables = managerService.fetchAllTablesForRestaurant(restaurantId);
        return ResponseEntity.ok(tables);
    }
}
