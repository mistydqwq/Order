package com.mistyd.order.ports.inbound;

import com.mistyd.order.common.BaseResponse;

public interface UpdateOrderStatusUseCase {
    Boolean updateOrderStatus(String orderId, int status);
}
