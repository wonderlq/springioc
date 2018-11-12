package com.merlin.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-11 22:09
 */
public class JavaProxyCreator implements AopProxy,InvocationHandler{

    private AdviseSupport adviseSupport;

    public JavaProxyCreator(AdviseSupport adviseSupport) {
        this.adviseSupport = adviseSupport;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{adviseSupport.getTargetSource().getTargetClass()},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = adviseSupport.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(adviseSupport.getTargetSource().getTarget(),method,args));
    }
}
