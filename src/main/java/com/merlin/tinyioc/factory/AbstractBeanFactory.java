package com.merlin.tinyioc.factory;

import com.merlin.tinyioc.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 19:16
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> map = new HashMap<>();

    @Override
    public void registerBean(String name, BeanDefinition beanDefinition) {
        map.put(name, beanDefinition);
    }

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = map.get(name);
        if (beanDefinition == null) {
            throw new Exception("not find beanDefinition {" + name + "}");
        }

        Object object = beanDefinition.getBean();
        if (object == null) {
            return createBean(beanDefinition);
        }

        return object;
    }

    protected abstract Object createBean(BeanDefinition beanDefinition);
}
