package com.mistyd.order.adapters.inbound;

public interface OrderServiceApi {
    Boolean updateOrderStatus(String orderId, int status);
    Boolean updatePaymentLink(String orderId, String paymentLink);
}
