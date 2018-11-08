package com.merlin.tinyioc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:06
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanMap = new HashMap<>();

    public Object getBean(String name) {
        assert name != null;
        return beanMap.get(name).getBean();
    }

    public void registerBean(String name, BeanDefinition beanDefinition) {
        beanMap.put(name, beanDefinition);
    }

}
