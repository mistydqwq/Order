package com.mistyd.order.domain.events;

import lombok.Data;

@Data
public class UpdateOrderStatusEvent {
    private final String orderId;
    private final int status;
}
