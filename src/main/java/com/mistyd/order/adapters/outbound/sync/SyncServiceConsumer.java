package com.mistyd.order.adapters.outbound.sync;

import com.mistyd.order.ports.outbound.sync.SyncServicePort;

public class SyncServiceConsumer implements SyncServicePort {
    @Override
    public boolean synctoDB(String orderId, String message) {
        return false;
    }
}
