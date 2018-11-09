package com.merlin.tinyioc.context;

import com.merlin.tinyioc.beans.factory.AbstractBeanFactory;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-09 16:45
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory abstractBeanFactory;

    public AbstractApplicationContext(AbstractBeanFactory abstractBeanFactory) {
        this.abstractBeanFactory = abstractBeanFactory;
    }

    @Override
    public Object getBean(String name) throws Exception {
        return abstractBeanFactory.getBean(name);
    }

    public abstract boolean refresh();
}
