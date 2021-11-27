package com.tistory.jaimemin.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 스프링은 @Controller 혹은 @RequestMapping 이 있어야 스프링 컨트롤러로 인식
@RequestMapping
@ResponseBody
public interface OrderControllerV1 {

    // interface에서는 파라미터명 같아도 명시해줘야함
    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
