package com.mistyd.order.application.queries;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.common.ErrorCode;
import com.mistyd.order.common.ResultUtils;
import com.mistyd.order.domain.entities.Order;
import com.mistyd.order.domain.valueobj.OrderVO;
import com.mistyd.order.ports.inbound.GetOrderStatusUseCase;
import com.mistyd.order.ports.outbound.OrderRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOrderStatusHandler implements GetOrderStatusUseCase {

    @Autowired
    private OrderRepositoryPort orderRepositoryPort;

    @Override
    public BaseResponse<Integer> getOrderStatus(String orderId) {
        Optional<Order> optionalOrder = orderRepositoryPort.findById(orderId);
        if (!optionalOrder.isPresent()) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR, "Order不存在");
        }

        Order order = optionalOrder.get();
        return ResultUtils.success(order.getStatus().getCode());
    }
}
