package com.merlin.ioctest.aop;

import com.merlin.ioctest.HelloServer;
import com.merlin.tinyioc.aop.AspectJExpressionPointcut;

import java.lang.reflect.Member;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-15 11:18
 */
public class AspectJExpressionPointcutTest {

    public static void main(String[] args) throws NoSuchMethodException {

        String expression = "execution(* com.merlin.ioctest.*.*(..))";
        AspectJExpressionPointcut expressionPointcut = new AspectJExpressionPointcut();
        expressionPointcut.setExpression(expression);

        boolean matches = expressionPointcut.matches(HelloServer.class);
        System.out.println(matches);



        String expression1 = "execution(* com.merlin.ioctest.*.*(..))";
        AspectJExpressionPointcut expressionPointcut1 = new AspectJExpressionPointcut();
        expressionPointcut1.setExpression(expression1);

        boolean matches1 = expressionPointcut1.matches(HelloServer.class.getDeclaredMethod("say"),HelloServer.class);
        System.out.println(matches1);


    }
}
