package com.restaurant.manager.entity;

import java.util.List;
import java.util.Map;

public class Order {
    Long orderId;
    Map<MenuItem,Integer> ordered_items_quantity;

    boolean isBillGenerated;
    boolean isBillPaid;

    double billAmount;
    double discount;
}
