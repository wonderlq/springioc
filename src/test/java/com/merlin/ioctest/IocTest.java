package com.merlin.ioctest;

import com.merlin.tinyioc.context.ClassPathXmlApplicationContext;


/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:15
 */
public class IocTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloServer helloServer1 = (HelloServer) applicationContext.getBean("helloServer");
        System.out.println(helloServer1.getName());
        System.out.println(helloServer1.getSayWord().getWord());
    }
}
