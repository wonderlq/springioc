package com.merlin.tinyioc;

import com.merlin.tinyioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-09 10:32
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {


    private Map<String, BeanDefinition> beanMap;


    private ResourceLoader resourceLoader;


    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.beanMap = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getBeanMap() {
        return beanMap;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
