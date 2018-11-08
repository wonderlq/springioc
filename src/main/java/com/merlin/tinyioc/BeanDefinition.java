package com.merlin.tinyioc;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:06
 */
public class BeanDefinition {

    private Object object;
    private Class clazz;
    private String className;
    private Properties properties;

    public BeanDefinition(Object object) {
        this.object = object;
    }

    public Object getBean() {
        return object;
    }

    public BeanDefinition(String className) {
        this.className = className;
        try {
            this.clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getClazz() {
        return clazz;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
