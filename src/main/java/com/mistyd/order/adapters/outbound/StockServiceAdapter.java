package com.mistyd.order.adapters.outbound;

import com.mistyd.order.domain.valueobj.OrderItem;
import com.mistyd.order.ports.outbound.StockServicePort;

import java.util.List;

public class StockServiceAdapter implements StockServicePort {
    @Override
    public boolean reserveStock(List<OrderItem> list) {
        return false;
    }

    @Override
    public boolean releaseStock(List<OrderItem> list) {
        return false;
    }
}
