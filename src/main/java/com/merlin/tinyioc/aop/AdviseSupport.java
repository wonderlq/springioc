package com.merlin.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-11 22:12
 */
public class AdviseSupport {
    private TargetSource targetSource;
    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
