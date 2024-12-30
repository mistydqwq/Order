package com.mistyd.order.application.commands;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.ports.inbound.UpdateOrderStatusUseCase;
import org.springframework.stereotype.Service;

public class UpdateOrderStatusHandler implements UpdateOrderStatusUseCase {
    @Override
    public Boolean updateOrderStatus(String orderId, int status) {
        return null;
    }
}
