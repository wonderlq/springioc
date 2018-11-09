package com.merlin.tinyioc.xml;

import com.merlin.tinyioc.AbstractBeanDefinitionReader;
import com.merlin.tinyioc.BeanDefinition;
import com.merlin.tinyioc.Properties;
import com.merlin.tinyioc.Property;
import com.merlin.tinyioc.io.ResourceLoader;
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

    private void parseBeanDefinition(Element node) {
        String name = node.getAttribute("name");
        String className = node.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition(className);
        Properties properties = new Properties();

        NodeList property = node.getElementsByTagName("proty");
        for (int i = 0; i < property.getLength(); i++) {
            Node propertyNode = property.item(i);
            if (propertyNode instanceof Element) {
                String proName = ((Element) propertyNode).getAttribute("name");
                Object value = ((Element) propertyNode).getAttribute("value");
                properties.addProperty(new Property(proName, value));
            }
        }
        beanDefinition.setProperties(properties);
        getBeanMap().put(name,beanDefinition);
    }
}
