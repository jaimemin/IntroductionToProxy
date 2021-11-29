package com.tistory.jaimemin.proxy.config.v1_proxy.interface_proxy;

import com.tistory.jaimemin.proxy.app.v1.OrderRepositoryV1;
import com.tistory.jaimemin.proxy.trace.TraceStatus;
import com.tistory.jaimemin.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;

    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepository.request()");
            // target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);

            throw e;
        }
    }
}
