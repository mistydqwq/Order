package com.mistyd.order.ports.inbound;

import com.mistyd.order.common.BaseResponse;

public interface UpdatePaymentLinkUseCase {
    Boolean updatePaymentLink(String orderId, String paymentLink);
}
