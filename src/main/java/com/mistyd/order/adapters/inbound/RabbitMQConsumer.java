package com.mistyd.order.adapters.inbound;

import com.google.gson.Gson;
import com.mistyd.order.domain.events.OrderCreateEvent;
import com.mistyd.order.infrastructure.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    private final Gson gson = new Gson(); // 初始化 Gson 实例

    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void handleOrderCreatedEvent(String message) {
        try {
            // 使用 Gson 将 JSON 字符串反序列化为 OrderCreateEvent 对象
            OrderCreateEvent event = gson.fromJson(message, OrderCreateEvent.class);
            System.out.println("Received event: " + event);
            // 处理事件逻辑
        } catch (Exception e) {
            System.err.println("Failed to process message: " + e.getMessage());
        }
    }
}
