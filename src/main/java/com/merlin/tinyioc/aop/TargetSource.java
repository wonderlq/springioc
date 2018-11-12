package com.merlin.tinyioc.aop;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-11 22:15
 */
public class TargetSource {
    private Class targetClass;
    private Object target;

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
