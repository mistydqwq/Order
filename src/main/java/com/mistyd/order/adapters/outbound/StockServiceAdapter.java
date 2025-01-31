package com.mistyd.order.adapters.outbound;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.domain.valueobj.OrderItem;
import com.mistyd.order.ports.outbound.StockServiceApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceAdapter implements StockServiceApi {

    @DubboReference(version = "1.0.0", check = false)
    private StockServiceApi stockServiceApi;

    @Override
    public BaseResponse<Boolean> reserveStock(String orderId, List<OrderItem> list) {
        return stockServiceApi.reserveStock(orderId, list);
        //return null;
    }

    @Override
    public boolean releaseStock(String orderId, List<OrderItem> list) {
        return stockServiceApi.releaseStock(orderId, list);
        //return false;
    }
}
