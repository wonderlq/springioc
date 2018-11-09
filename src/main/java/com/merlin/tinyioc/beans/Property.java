package com.merlin.tinyioc.beans;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 22:27
 */
public class Property {
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

    public Property(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
