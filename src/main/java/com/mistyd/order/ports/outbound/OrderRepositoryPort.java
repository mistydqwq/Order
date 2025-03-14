package com.mistyd.order.ports.outbound;

import com.mistyd.order.domain.entities.Order;

import java.util.Optional;

public interface OrderRepositoryPort {
    Optional<Order> findById(String orderId);
    boolean save(Order order);
    boolean update(Order order);
    boolean updateStatus(String orderId, int status);
    boolean updatePaymentLink(String orderId, String paymentLink);
    boolean delete(String orderId);
}
