package com.mistyd.order.ports.outbound;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.domain.valueobj.OrderItem;

import java.util.List;

public interface StockServiceApi {
    BaseResponse<Boolean> reserveStock(String orderId, List<OrderItem>list);
    boolean releaseStock(String orderId, List<OrderItem>list);
}
