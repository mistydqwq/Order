package com.mistyd.order.adapters.outbound;

import com.mistyd.order.domain.events.OrderCreateEvent;
import com.mistyd.order.ports.outbound.EventPublisherPort;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher implements EventPublisherPort {
    @Override
    public boolean publishEvent(OrderCreateEvent orderCreateEvent) {
        return false;
    }
}
