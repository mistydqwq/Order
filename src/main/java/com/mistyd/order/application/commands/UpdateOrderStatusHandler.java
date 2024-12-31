package com.mistyd.order.application.commands;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.ports.inbound.UpdateOrderStatusUseCase;
import com.mistyd.order.ports.outbound.OrderRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateOrderStatusHandler implements UpdateOrderStatusUseCase {

    @Autowired
    private OrderRepositoryPort orderRepositoryPort;

    @Override
    public Boolean updateOrderStatus(String orderId, int status) {
        return orderRepositoryPort.updateStatus(orderId, status);
    }
}
