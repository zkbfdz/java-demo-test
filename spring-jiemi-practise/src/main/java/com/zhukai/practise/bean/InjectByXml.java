package com.zhukai.practise.bean;

import com.zhukai.practise.bean.FXNewsProvider;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by kai.zhu on 2018/9/14/014.
 */
public class InjectByXml {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXMLFile(beanFactory);
        FXNewsProvider fxNewsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        fxNewsProvider.getAndPersistNews();
    }

    public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("classpath:news-config.xml");
        return (BeanFactory) registry;
    }

    @Test
    public void test4_3_7__1() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("4.3.7-1.xml"));
        MockNewsPersister mockNewsPersister = (MockNewsPersister) xmlBeanFactory.getBean("mockPersister");
        mockNewsPersister.persistNews();
        mockNewsPersister.persistNews();
    }
}