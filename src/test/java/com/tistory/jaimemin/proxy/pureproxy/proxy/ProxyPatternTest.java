package com.tistory.jaimemin.proxy.pureproxy.proxy;

import com.tistory.jaimemin.proxy.pureproxy.proxy.code.CacheProxy;
import com.tistory.jaimemin.proxy.pureproxy.proxy.code.ProxyPatternClient;
import com.tistory.jaimemin.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        // 총 3초 걸림
        // 한번 조회하면 변하지 않는 데이터이므로 이미 조회한 데이터를 캐시에 보관해두고 사용하는 것이 효율적
        // 따라서, 3초가 걸린다는 것은 비효율적
        for (int i = 0; i < 3; i++) {
            client.execute();
        }
    }

    // 총 1.143초 걸림
    // 효율적 구조
    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        for (int i = 0; i < 3; i++) {
            client.execute();
        }
    }
}
