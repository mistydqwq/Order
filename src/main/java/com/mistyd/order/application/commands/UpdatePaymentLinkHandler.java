package com.mistyd.order.application.commands;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.ports.inbound.UpdatePaymentLinkUseCase;

public class UpdatePaymentLinkHandler implements UpdatePaymentLinkUseCase {
    @Override
    public Boolean updatePaymentLink(String orderId, String paymentLink) {
        return null;
    }
}
