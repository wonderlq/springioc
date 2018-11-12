package com.merlin.ioctest.aop;

import com.merlin.ioctest.HelloServer;
import com.merlin.ioctest.HelloServerInterface;
import com.merlin.tinyioc.aop.AdviseSupport;
import com.merlin.tinyioc.aop.AopProxy;
import com.merlin.tinyioc.aop.JavaProxyCreator;
import com.merlin.tinyioc.aop.TargetSource;
import com.merlin.tinyioc.context.ClassPathXmlApplicationContext;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-11 22:43
 */
public class AopTest {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloServer helloServer = (HelloServer) applicationContext.getBean("helloServer");

        /**设置aop**/
        AdviseSupport adviseSupport = new AdviseSupport();
        TargetSource targetSource = new TargetSource();
        targetSource.setTarget(helloServer);
        targetSource.setTargetClass(HelloServerInterface.class);
        adviseSupport.setTargetSource(targetSource); //切点

        adviseSupport.setMethodInterceptor(new TimeInterceptor());//通知

        AopProxy aopProxy = new JavaProxyCreator(adviseSupport);
        HelloServerInterface helloServerProxy = (HelloServerInterface) aopProxy.getProxy();
        helloServerProxy.say();

    }
}
