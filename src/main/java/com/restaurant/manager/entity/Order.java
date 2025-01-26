package com.restaurant.manager.entity;

import java.util.Map;

public class Order {
    Long orderId;
    Map<MenuItemEntity,Integer> ordered_items_quantity;

    boolean isBillGenerated;
    boolean isBillPaid;

    double billAmount;
    double discount;
}
