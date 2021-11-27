package com.tistory.jaimemin.proxy.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;

    public OrderControllerV3(OrderServiceV3 orderService) {
        this.orderService = orderService;
    }

    // LogTrace 적용 대상
    @GetMapping("/v3/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);

        return "ok";
    }

    // LogTrace 비적용 대상
    @GetMapping("/v3/no-log")
    public String noLog() {
        return "ok";
    }
}
