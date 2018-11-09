package com.merlin.ioctest;

import com.merlin.tinyioc.BeanDefinition;
import com.merlin.tinyioc.Properties;
import com.merlin.tinyioc.Property;
import com.merlin.tinyioc.factory.AutowireBeanFactory;
import com.merlin.tinyioc.factory.BeanFactory;
import com.merlin.tinyioc.io.ResourceLoader;
import com.merlin.tinyioc.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:15
 */
public class IocTest {

    public static void main(String[] args) {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinition("application.xml");

        BeanFactory beanFactory = new AutowireBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : reader.getBeanMap().entrySet()) {
            beanFactory.registerBean(entry.getKey(), entry.getValue());
        }

        HelloServer helloServer1 = (HelloServer) beanFactory.getBean("helloServer");
        System.out.println(helloServer1.getName());
    }
}
