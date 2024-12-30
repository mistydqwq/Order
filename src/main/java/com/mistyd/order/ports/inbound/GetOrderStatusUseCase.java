package com.mistyd.order.ports.inbound;

import com.mistyd.order.common.BaseResponse;

public interface GetOrderStatusUseCase {
    BaseResponse<Integer> getOrderStatus(String orderId);
}
