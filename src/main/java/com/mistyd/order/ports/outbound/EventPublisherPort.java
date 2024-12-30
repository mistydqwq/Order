package com.mistyd.order.ports.outbound;

import com.mistyd.order.domain.events.OrderCreateEvent;

public interface EventPublisherPort {
    boolean publishEvent(OrderCreateEvent orderCreateEvent);
}
