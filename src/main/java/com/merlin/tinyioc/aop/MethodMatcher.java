package com.merlin.tinyioc.aop;

import java.lang.reflect.Method;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-12 21:28
 */
public interface MethodMatcher {

    boolean matches(Method method , Class targetClass);
}
