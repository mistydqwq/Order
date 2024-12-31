package com.mistyd.order.application.commands;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.common.ErrorCode;
import com.mistyd.order.common.ResultUtils;
import com.mistyd.order.domain.entities.Order;
import com.mistyd.order.domain.enums.OrderStatusEnum;
import com.mistyd.order.domain.events.OrderCreateEvent;
import com.mistyd.order.domain.valueobj.OrderVO;
import com.mistyd.order.ports.inbound.CreateOrderUseCase;
import com.mistyd.order.ports.outbound.EventPublisherPort;
import com.mistyd.order.ports.outbound.OrderRepositoryPort;
import com.mistyd.order.ports.outbound.StockServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateOrderHandler implements CreateOrderUseCase {

    @Autowired
    private StockServicePort stockServicePort;
    @Autowired
    private OrderRepositoryPort orderRepositoryPort;
    @Autowired
    private EventPublisherPort eventPublisherPort;


    @Override
    public BaseResponse<String> createOrder(CreateOrderCommand createOrderCommand) {
        OrderVO orderVO = new OrderVO();
        orderVO.setCustomerId(createOrderCommand.getCustomerId());
        orderVO.setItems(createOrderCommand.getItems());
        orderVO.setNote(createOrderCommand.getNote());
        Order order = Order.fromVO(orderVO);
        order.setOrderId(UUID.randomUUID().toString());
        order.setStatus(OrderStatusEnum.PENDING);

        // check order
        if(!order.isValid()){
            return ResultUtils.error(ErrorCode.PARAMS_ERROR, "Params error");
        }

        // reserve stock
        BaseResponse<Boolean>reserveRes=stockServicePort.reserveStock(order.getItems());
        if(reserveRes.getCode()!=0){
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, reserveRes.getDescription());
        }

        // save order
        order.setTotalAmount(order.calculateTotalAmount());
        order.setStatus(OrderStatusEnum.CREATED);
        boolean saveRes=orderRepositoryPort.save(order);
        if(!saveRes){
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "Save order error");
        }

        OrderCreateEvent orderCreatedEvent = new OrderCreateEvent(order.getOrderId(), order.getItems(), order.getNote());
        boolean publishRes=eventPublisherPort.publishEvent(orderCreatedEvent);
        if(!publishRes){
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "Publish event error");
        }

        return ResultUtils.success(order.getOrderId());

        // 需要事务，以及如果有状态出问题需要回滚状态
    }
}
