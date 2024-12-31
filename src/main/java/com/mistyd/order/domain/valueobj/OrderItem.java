package com.mistyd.order.domain.valueobj;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private final String productId;
    private final String productName;
    private final Integer quantity;
    private final BigDecimal price;
}
