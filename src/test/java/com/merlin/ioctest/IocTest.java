package com.merlin.ioctest;

import com.merlin.tinyioc.BeanDefinition;
import com.merlin.tinyioc.BeanFactory;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:15
 */
public class IocTest {

    public static void main(String[] args) {

        HelloServer helloServer = new HelloServer();
        BeanDefinition beanDefinition = new BeanDefinition(helloServer);

        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloServer", beanDefinition);

        HelloServer helloServer1 = (HelloServer) beanFactory.getBean("helloServer");
        System.out.println(helloServer);
        System.out.println(helloServer1);
    }
}
