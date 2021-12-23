package com.tistory.jaimemin.proxy.config.v4_postprocessor;

import com.tistory.jaimemin.proxy.config.AppV1Config;
import com.tistory.jaimemin.proxy.config.AppV2Config;
import com.tistory.jaimemin.proxy.config.v3_proxyfactory.advice.LogTraceAdvice;
import com.tistory.jaimemin.proxy.config.v4_postprocessor.postprocessor.PackageLogTracePostProcessor;
import com.tistory.jaimemin.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class BeanPostProcessorConfig {

    @Bean
    public PackageLogTracePostProcessor logTracePostProcessor(LogTrace logTrace) {
        return new PackageLogTracePostProcessor("com.tistory.jaimemin.proxy.app", getAdvisor(logTrace));
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        // pointcut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        // advice
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}