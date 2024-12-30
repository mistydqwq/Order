package com.mistyd.order.ports.outbound;

import com.mistyd.order.domain.valueobj.OrderItem;

import java.util.List;

public interface StockServicePort {
    boolean reserveStock(List<OrderItem>list);
    boolean releaseStock(List<OrderItem>list);
}
