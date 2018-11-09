package com.merlin.ioctest;

import com.merlin.tinyioc.beans.BeanDefinition;
import com.merlin.tinyioc.beans.factory.AutowireBeanFactory;
import com.merlin.tinyioc.beans.factory.BeanFactory;
import com.merlin.tinyioc.beans.io.ResourceLoader;
import com.merlin.tinyioc.beans.xml.XmlBeanDefinitionReader;
import com.merlin.tinyioc.context.ApplicationContext;
import com.merlin.tinyioc.context.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:15
 */
public class IocTest {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        ((ClassPathXmlApplicationContext) applicationContext).refresh();
        HelloServer helloServer1 = (HelloServer) applicationContext.getBean("helloServer");
        System.out.println(helloServer1.getName());
        System.out.println(helloServer1.getSayWord().getWord());
    }
}
