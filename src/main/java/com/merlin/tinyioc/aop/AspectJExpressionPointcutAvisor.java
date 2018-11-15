package com.merlin.tinyioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-15 10:27
 */
public class AspectJExpressionPointcutAvisor implements PointCutAdvisor {
    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    private Advice advice;

    @Override
    public PointCut getPointCut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setPointcut(AspectJExpressionPointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
