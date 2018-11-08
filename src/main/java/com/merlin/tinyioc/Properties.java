package com.merlin.tinyioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-08 22:27
 */
public class Properties {


    private List<Property> propertyValues = new ArrayList<>();

    public void addProperty(Property property){
        propertyValues.add(property);
    }

    public List<Property> getPropertyValues() {
        return propertyValues;
    }
}
