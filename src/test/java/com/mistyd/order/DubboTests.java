package com.mistyd.order;

import com.mistyd.order.adapters.inbound.OrderServiceApi;
import com.mistyd.order.adapters.inbound.RabbitMQConsumer;
import com.mistyd.order.adapters.outbound.RabbitMQPublisher;
import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.domain.events.OrderCreateEvent;
import com.mistyd.order.domain.valueobj.OrderItem;
import com.mistyd.order.ports.inbound.UpdateOrderStatusUseCase;
import com.mistyd.order.ports.outbound.StockServiceApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableDubbo
class DubboTests {

    @DubboReference(version = "1.0.0", check = false)
    private OrderServiceApi orderServiceApi;

    @DubboReference(version = "1.0.0", check = false)
    private StockServiceApi stockServiceApi;

    @Test
    void testUpdateOrderStatus() {
        // 1. 定义一个测试订单
        String testOrderId = "ac06f600-6bc0-44a4-9cb3-ab5af1060eb4";
        int testStatus = 1;

        // 2. 更新订单状态
        boolean isUpdated = orderServiceApi.updateOrderStatus(testOrderId, testStatus);

        // 验证更新是否成功
        assertThat(isUpdated).isTrue();
    }

    @Test
    void testStockApi(){
        String testOrderId = "ac06f600-6bc0-44a4-9cb3-ab5af1060eb4";
        List<OrderItem> testOrderItems = List.of(new OrderItem("1", "1", 1, new BigDecimal("100.00")));
        BaseResponse<Boolean> res = stockServiceApi.reserveStock(testOrderId, testOrderItems);
        System.out.println(res);
    }

}
