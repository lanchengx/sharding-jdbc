package com.hjc.sharding.demo.aop;

import io.shardingsphere.api.HintManager;
import io.shardingsphere.core.hint.HintManagerHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @Author: lanchengx
 * @Date: 2020/5/10 0010
 */
@Aspect
@Component
@Order(0)
@Lazy(false)
@Slf4j
public class ShardingAop {


    @Pointcut(" @annotation(org.springframework.transaction.annotation.Transactional)")
    public void checkArgs() {
    }

    // 这里切到你的方法目录
    @Before("checkArgs()")
    public void process(JoinPoint joinPoint) throws  SecurityException {
        String methodName = joinPoint.getSignature().getName();
        Class clazz = joinPoint.getTarget().getClass();
//        if (!HintManagerHolder.isMasterRouteOnly()){
//            log.debug("类： {}， 方法： {}， 持有事务，强制使用主库", clazz.getName(), methodName);
//            HintManager hintManager = HintManager.getInstance();
//            hintManager.setMasterRouteOnly();
//        }
    }

    @After("checkArgs()")
    public void afterAdvice() {
        HintManagerHolder.clear();
    }

}
