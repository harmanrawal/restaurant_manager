package com.restaurant.manager.service;

import com.restaurant.manager.dto.AddTablesRequest;
import com.restaurant.manager.dto.AddTablesResponse;
import com.restaurant.manager.entity.TableEntity;
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
}
