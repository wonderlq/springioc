package com.merlin.tinyioc;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 17:06
 */
public class BeanReference {

    private String name;
    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public BeanReference(String name) {
        this.name = name;
    }
}
