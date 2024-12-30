package com.mistyd.order.domain.repositories;

import com.mistyd.order.domain.entities.Order;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(String orderId);
    boolean save(Order order);
    boolean update(Order order);
}
