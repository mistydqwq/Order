package com.mistyd.order.application.commands;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.ports.inbound.CreateOrderUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderHandler implements CreateOrderUseCase {
    @Override
    public BaseResponse<String> createOrder(CreateOrderCommand createOrderCommand) {
        return null;
    }
}
