package com.tistory.jaimemin.proxy.config.v1_proxy.concrete_proxy;

import com.tistory.jaimemin.proxy.app.v2.OrderControllerV2;
import com.tistory.jaimemin.proxy.trace.TraceStatus;
import com.tistory.jaimemin.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;

    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null); // 구조상 어쩔 수 없이 호출해야하므로
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderController.request()");
            // target 호출
            String result = target.request(itemId);
            logTrace.end(status);

            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);

            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
