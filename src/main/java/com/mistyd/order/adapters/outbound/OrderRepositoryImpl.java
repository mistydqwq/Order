package com.mistyd.order.adapters.outbound;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mistyd.order.domain.entities.Order;
import com.mistyd.order.domain.valueobj.OrderVO;
import com.mistyd.order.ports.outbound.OrderRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepositoryPort {

    private final OrderMapper orderMapper;

    public OrderRepositoryImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Optional<Order> findById(String orderId) {
        QueryWrapper<OrderVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        return Optional.ofNullable(orderMapper.selectOne(queryWrapper))
                .map(Order::fromVO);
    }

    @Override
    public boolean save(Order order) {
        return orderMapper.insert(order.toVO()) == 1;
    }

    @Override
    public boolean update(Order order) {
        UpdateWrapper<OrderVO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("order_id", order.getOrderId());
        OrderVO orderVO = order.toVO();
        return orderMapper.update(orderVO, updateWrapper) == 1;
    }

    @Override
    public boolean updateStatus(String orderId, int status) {
        UpdateWrapper<OrderVO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("order_id", orderId);
        OrderVO orderVO = new OrderVO();
        orderVO.setStatus(status);
        return orderMapper.update(orderVO, updateWrapper) == 1;
    }

    @Override
    public boolean updatePaymentLink(String orderId, String paymentLink) {
        UpdateWrapper<OrderVO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("order_id", orderId);
        OrderVO orderVO = new OrderVO();
        orderVO.setPaymentLink(paymentLink);
        return orderMapper.update(orderVO, updateWrapper) == 1;
    }

    @Override
    public boolean delete(String orderId) {
        QueryWrapper<OrderVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        return orderMapper.delete(queryWrapper) == 1;
    }
}
