package com.merlin.tinyioc.factory;

import com.merlin.tinyioc.BeanDefinition;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 19:17
 */
public class AutowireBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getClazz().newInstance();
        } catch (Exception e) {
            System.out.println("create new instance error" + e.getMessage());
        }
        return null;
    }
}
