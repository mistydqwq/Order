package com.mistyd.order.adapters.outbound;

import com.mistyd.order.common.BaseResponse;
import com.mistyd.order.domain.valueobj.OrderItem;
import com.mistyd.order.ports.outbound.StockServiceApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceAdapter implements StockServiceApi {

    //@DubboReference(version = "1.0.0")
    //private StockServicePort stockServicePort;

    @Override
    public BaseResponse<Boolean> reserveStock(List<OrderItem> list) {
        //return stockServicePort.reserveStock(list);
        return null;
    }

    @Override
    public boolean releaseStock(List<OrderItem> list) {
        //return stockServicePort.releaseStock(list);
        return false;
    }
}
