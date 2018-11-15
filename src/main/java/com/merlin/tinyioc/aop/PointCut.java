package com.merlin.tinyioc.aop;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-12 21:36
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMather();
}
