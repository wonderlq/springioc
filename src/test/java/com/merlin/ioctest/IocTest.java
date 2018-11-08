package com.merlin.ioctest;

import com.merlin.tinyioc.BeanDefinition;
import com.merlin.tinyioc.factory.AutowireBeanFactory;
import com.merlin.tinyioc.factory.BeanFactory;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:15
 */
public class IocTest {

    public static void main(String[] args) {


        BeanDefinition beanDefinition = new BeanDefinition("com.merlin.ioctest.HelloServer");

        BeanFactory beanFactory = new AutowireBeanFactory();
        beanFactory.registerBean("helloServer", beanDefinition);

        HelloServer helloServer1 = (HelloServer) beanFactory.getBean("helloServer");
        System.out.println(helloServer1);
    }
}
