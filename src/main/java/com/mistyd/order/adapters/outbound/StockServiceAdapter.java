package com.mistyd.order.adapters.outbound;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.domain.valueobj.OrderItem;
import com.mistyd.order.ports.outbound.StockServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceAdapter implements StockServicePort {
    @Override
    public BaseResponse<Boolean> reserveStock(List<OrderItem> list) {
        return null;
    }

    @Override
    public boolean releaseStock(List<OrderItem> list) {
        return false;
    }
}
