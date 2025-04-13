package com.restaurant.manager.service;

import com.restaurant.manager.dto.AddMenuItemRequest;
import com.restaurant.manager.dto.AddMenuItemResponse;
import com.restaurant.manager.dto.AddTablesRequest;
import com.restaurant.manager.dto.AddTablesResponse;
import com.restaurant.manager.entity.MenuItemEntity;
import com.restaurant.manager.entity.TableEntity;
import com.restaurant.manager.repository.MenuRepository;
import com.restaurant.manager.repository.RestaurantRepository;
import com.restaurant.manager.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService {
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuRepository menuRepository;

    public AddTablesResponse addTables(AddTablesRequest request){
        if(!restaurantExists(request.getRestaurantId())){
            throw new IllegalArgumentException("Restaurant not found");
        }
        List<TableEntity> newTableList = new ArrayList<>();
        for(int i=0; i<request.getQuantity();i++){
            TableEntity table = new TableEntity();
            table.setRestaurantId(request.getRestaurantId());
            table.setCapacity(request.getMaxCapacity());
            table.setStatus("FREE");
            newTableList.add(table);
        }

        List<TableEntity> savedTables = tableRepository.saveAll(newTableList);
        List<Long> tableIds = savedTables.stream().map(TableEntity::getTable_id).collect(Collectors.toList());

        return new AddTablesResponse(true,tableIds);
    }

    public boolean restaurantExists(Long restaurantId){
        return restaurantId != null && restaurantRepository.existsById(restaurantId);
    }

    public List<TableEntity> fetchAllTablesForRestaurant(Long restaurantId){
        return tableRepository.findByRestaurantId(restaurantId);
    }

    public AddMenuItemResponse addMenuItem(AddMenuItemRequest request){
        if(!restaurantExists(request.getRestaurantId())){
            throw new IllegalArgumentException("Restaurant Not Found : Add to Menu Not Possible");
        }
        MenuItemEntity menuItem = new MenuItemEntity();
        menuItem.setName(request.getName());
        menuItem.setRestaurantId(request.getRestaurantId());
        menuItem.setPrice(request.getPrice());
        menuItem.setDescription(request.getDescription());
        menuItem.setAvailability(request.isAvailability());
        menuItem.setCategory(request.getCategory());
        menuRepository.save(menuItem);
        return new AddMenuItemResponse(true, menuItem.getId(), menuItem.getName());
    }

    public List<MenuItemEntity> fetchAllMenuItems(Long restaurantId){
        return menuRepository.findByRestaurantId(restaurantId);
    }

    public List<TableEntity> getAllTables(Long restaurantId){
        if(!restaurantExists(restaurantId)){
            throw new IllegalArgumentException("Restaurant not found");
        }
        return tableRepository.findByRestaurantId(restaurantId);
    }
}
