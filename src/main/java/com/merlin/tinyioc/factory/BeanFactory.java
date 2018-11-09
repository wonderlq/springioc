package com.merlin.tinyioc.factory;

import com.merlin.tinyioc.BeanDefinition;


/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:06
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBean(String name, BeanDefinition beanDefinition);
}
