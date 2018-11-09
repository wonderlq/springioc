package com.merlin.tinyioc.beans.factory;

import com.merlin.tinyioc.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 19:16
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> map = new HashMap<>();
    private List<String> beanList = new ArrayList<>();

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

    public void registryBean(String name, BeanDefinition beanDefinition) {
        map.put(name, beanDefinition);
        beanList.add(name);
    }

    public void initBean() throws Exception {
        for (String beanName : beanList) {
            getBean(beanName);
        }

    }
}

