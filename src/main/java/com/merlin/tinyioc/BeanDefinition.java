package com.merlin.tinyioc;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:06
 */
public class BeanDefinition {

    private Object object;

    public BeanDefinition(Object object) {
        this.object = object;
    }

    public Object getBean() {
        return object;
    }
}
