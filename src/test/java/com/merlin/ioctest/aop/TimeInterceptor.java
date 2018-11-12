package com.merlin.ioctest.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-11 22:34
 */
public class TimeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(methodInvocation.getMethod().getName()+"start, now time " + System.nanoTime());
        Object object =  methodInvocation.proceed();
        System.out.println(methodInvocation.getMethod().getName()+"end, now time " + System.nanoTime());
        return object;
    }
}
