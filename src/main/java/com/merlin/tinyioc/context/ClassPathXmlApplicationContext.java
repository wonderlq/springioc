package com.merlin.tinyioc.context;

import com.merlin.tinyioc.beans.BeanDefinition;
import com.merlin.tinyioc.beans.factory.AbstractBeanFactory;
import com.merlin.tinyioc.beans.factory.AutowireBeanFactory;
import com.merlin.tinyioc.beans.factory.BeanFactory;
import com.merlin.tinyioc.beans.io.ResourceLoader;
import com.merlin.tinyioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-09 16:45
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String location;

    public ClassPathXmlApplicationContext(String location) {
        this(location, new AutowireBeanFactory());
    }

    public ClassPathXmlApplicationContext(String location, AutowireBeanFactory autowireBeanFactory) {
        super(autowireBeanFactory);
        this.location = location;
        refresh();
    }

    @Override
    public boolean refresh() {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(location);

        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getBeanMap().entrySet()) {
            abstractBeanFactory.registryBean(entry.getKey(), entry.getValue());
        }
        return true;
    }


}
