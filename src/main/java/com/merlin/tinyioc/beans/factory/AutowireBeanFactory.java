package com.merlin.tinyioc.beans.factory;

import com.merlin.tinyioc.beans.BeanDefinition;
import com.merlin.tinyioc.beans.BeanReference;
import com.merlin.tinyioc.beans.Property;

import java.lang.reflect.Field;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 19:17
 */
public class AutowireBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getClazz().newInstance();
            beanDefinition.setObject(bean); //先设置对象，防止循环引用拿不到对象
            applyProperty(bean, beanDefinition);
            return bean;
        } catch (Exception e) {
            System.out.println("create new instance error" + e.getMessage());
        }
        return null;
    }

    private void applyProperty(Object bean, BeanDefinition bd) {
        try {
            for (Property property : bd.getProperties().getPropertyValues()) {
                Field field = bean.getClass().getDeclaredField(property.getName());
                field.setAccessible(true);

                if (property.getValue() instanceof BeanReference) {
                    Object ob = getBean(((BeanReference) property.getValue()).getName());
                    field.set(bean, ob);
                } else {
                    field.set(bean, property.getValue());

                }
            }
        } catch (Exception e) {
            System.out.println("apply properties exception " + e.getMessage());

        }

    }
}
