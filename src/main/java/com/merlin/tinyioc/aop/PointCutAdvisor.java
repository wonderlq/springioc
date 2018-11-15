package com.merlin.tinyioc.aop;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-12 21:39
 */
public interface PointCutAdvisor extends Advisor{
   PointCut getPointCut();
}
