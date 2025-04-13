package com.restaurant.manager.controller;

import com.restaurant.manager.dto.AddMenuItemRequest;
import com.restaurant.manager.dto.AddMenuItemResponse;
import com.restaurant.manager.dto.AddTablesRequest;
import com.restaurant.manager.dto.AddTablesResponse;
import com.restaurant.manager.entity.MenuItemEntity;
import com.restaurant.manager.service.ManagerService;
import com.restaurant.manager.entity.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping("/addMenuItem")
    public AddMenuItemResponse addMenuItem(@RequestBody AddMenuItemRequest request){
        AddMenuItemResponse response = managerService.addMenuItem(request);
        return response;
    }

    @GetMapping("/getMenu/{restaurantId}")
    public ResponseEntity<List<MenuItemEntity>> getMenuForRestaurant(@PathVariable Long restaurantId){
        return ResponseEntity.ok(managerService.fetchAllMenuItems(restaurantId));
    }
}
