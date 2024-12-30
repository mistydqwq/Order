package com.mistyd.order.ports.inbound;

import com.mistyd.order.application.commands.CreateOrderCommand;
import com.mistyd.order.common.BaseResponse;

public interface CreateOrderUseCase {
    BaseResponse<String> createOrder(CreateOrderCommand createOrderCommand);
}
