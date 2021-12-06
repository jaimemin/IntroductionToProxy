package com.tistory.jaimemin.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();
        
        // 공통 로직1 시작
        log.info("start");
        String result = target.callA();
        log.info("result = {}", result);
        // 공통 로직1 종료

        // 공통 로직2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result2 = {}", result2);
        // 공통 로직2 종료
        
        // 공통1 공통2 호출하는 메서드만 다르고 구조 동일
    }

    @Test
    void reflection1() throws Exception {
        // 클래스 정보
        Class classHello = Class.forName("com.tistory.jaimemin.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // 클래스나 메서드를 동적으로 호출 가능
        // callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result = methodCallA.invoke(target);
        log.info("result = {}", result);

        // callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2 = {}", result2);
    }

    @Test
    void reflection2() throws Exception {
        // 클래스 정보
        Class classHello = Class.forName("com.tistory.jaimemin.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // 클래스나 메서드를 동적으로 호출 가능
        // callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        // callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result = {}", result);
    }
    
    @Slf4j
    static class Hello {
        
        public String callA() {
            log.info("Call A");
            
            return "A";
        }

        public String callB() {
            log.info("Call B");

            return "B";
        }
    }
}
