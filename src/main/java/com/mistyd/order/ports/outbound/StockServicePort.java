package com.mistyd.order.ports.outbound;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.domain.valueobj.OrderItem;

import java.util.List;

public interface StockServicePort {
    BaseResponse<Boolean> reserveStock(List<OrderItem>list);
    boolean releaseStock(List<OrderItem>list);
}
