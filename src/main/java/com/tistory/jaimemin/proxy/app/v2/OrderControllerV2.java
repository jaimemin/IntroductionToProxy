package com.tistory.jaimemin.proxy.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping
@ResponseBody
// @Controller는 ComponentScan 대상
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    // LogTrace 적용 대상
    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);

        return "ok";
    }

    // LogTrace 비적용 대상
    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }
}
