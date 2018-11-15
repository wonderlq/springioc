package com.merlin.tinyioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-12 21:38
 */
public interface Advisor {

    Advice getAdvice();
}
