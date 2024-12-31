package com.mistyd.order.application.commands;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.ports.inbound.UpdatePaymentLinkUseCase;
import com.mistyd.order.ports.outbound.OrderRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePaymentLinkHandler implements UpdatePaymentLinkUseCase {

    @Autowired
    private OrderRepositoryPort orderRepositoryPort;

    @Override
    public Boolean updatePaymentLink(String orderId, String paymentLink) {
        return orderRepositoryPort.updatePaymentLink(orderId, paymentLink);
    }
}
