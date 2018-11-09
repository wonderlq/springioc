package com.merlin.tinyioc.beans.xml;

import com.merlin.tinyioc.beans.AbstractBeanDefinitionReader;
import com.merlin.tinyioc.beans.BeanDefinition;
import com.merlin.tinyioc.beans.BeanReference;
import com.merlin.tinyioc.beans.Properties;
import com.merlin.tinyioc.beans.Property;
import com.merlin.tinyioc.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author lq
 * @since 1.0.0
 * Created On 2018-11-09 10:51
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinition(String location) {
        try {
            InputStream inputStream = getResourceLoader().loadResource(location).getInputStream();
            doLoadBeanDefinition(inputStream);
        } catch (Exception e) {
            System.out.println("xml loadBean exception " + e.getMessage());
        }
    }

    private void doLoadBeanDefinition(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        Element root = document.getDocumentElement();
        NodeList ls = root.getChildNodes();
        for (int i = 0; i < ls.getLength(); i++) {
            Node node = ls.item(i);
            if (node instanceof Element) {
                parseBeanDefinition((Element) node);
            }
        }

    }

    private void parseBeanDefinition(Element node) throws Exception {
        String name = node.getAttribute("name");
        String className = node.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition(className);
        Properties properties = new Properties();

        NodeList property = node.getElementsByTagName("proty");
        for (int i = 0; i < property.getLength(); i++) {
            Node propertyNode = property.item(i);
            if (propertyNode instanceof Element) {
                String proName = ((Element) propertyNode).getAttribute("name");
                String value = ((Element) propertyNode).getAttribute("value");
                if (value != null && value.length() > 0) {
                    properties.addProperty(new Property(proName, value));
                } else {
                    value = ((Element) propertyNode).getAttribute("ref");
                    if (value == null || value.length() == 0) {
                        throw new Exception("bean definition error,need a value");
                    }
                    properties.addProperty(new Property(proName, new BeanReference(value)));
                }
            }
        }
        beanDefinition.setProperties(properties);
        getBeanMap().put(name, beanDefinition);
    }
}
