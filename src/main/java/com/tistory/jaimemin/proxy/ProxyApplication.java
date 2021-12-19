package com.tistory.jaimemin.proxy;

import com.tistory.jaimemin.proxy.config.AppV1Config;
import com.tistory.jaimemin.proxy.config.AppV2Config;
import com.tistory.jaimemin.proxy.config.v1_proxy.ConcreteProxyConfig;
import com.tistory.jaimemin.proxy.config.v1_proxy.InterfaceProxyConfig;
import com.tistory.jaimemin.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import com.tistory.jaimemin.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import com.tistory.jaimemin.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import com.tistory.jaimemin.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import com.tistory.jaimemin.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import com.tistory.jaimemin.proxy.trace.logtrace.LogTrace;
import com.tistory.jaimemin.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

// @Import({AppV1Config.class, AppV2Config.class})
// @Import(InterfaceProxyConfig.class)
// @Import(DynamicProxyFilterConfig.class)
// @Import(ProxyFactoryConfigV1.class)
// @Import(ProxyFactoryConfigV2.class)
@Import(BeanPostProcessorConfig.class)
@SpringBootApplication(scanBasePackages = "com.tistory.jaimemin.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
