package com.mistyd.order.adapters.inbound;

import com.mistyd.order.ports.inbound.UpdateOrderStatusUseCase;
import com.mistyd.order.ports.inbound.UpdatePaymentLinkUseCase;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class DubboConsumer implements UpdateOrderStatusUseCase, UpdatePaymentLinkUseCase{
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final UpdatePaymentLinkUseCase updatePaymentLinkUseCase;

    public DubboConsumer(UpdateOrderStatusUseCase updateOrderStatusUseCase, UpdatePaymentLinkUseCase updatePaymentLinkUseCase) {
        this.updateOrderStatusUseCase = updateOrderStatusUseCase;
        this.updatePaymentLinkUseCase = updatePaymentLinkUseCase;
    }

    public Boolean updateOrderStatus(String orderId, int status) {
        return updateOrderStatusUseCase.updateOrderStatus(orderId, status);
    }

    public Boolean updatePaymentLink(String orderId, String paymentLink) {
        return updatePaymentLinkUseCase.updatePaymentLink(orderId, paymentLink);
    }
}
