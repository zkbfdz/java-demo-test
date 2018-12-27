package com.zhukai.practise.bean;

import com.zhukai.practise.bean.DowJonesNewsListener;
import com.zhukai.practise.bean.DowJonesNewsPersister;
import com.zhukai.practise.bean.FXNewsProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Created by kai.zhu on 2018/9/14/014.
 */
public class InjectByCode {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanFactory);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();

    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);

        registry.registerBeanDefinition("djNewsProvider", newsProvider);
        registry.registerBeanDefinition("djListener", newsListener);
        registry.registerBeanDefinition("djPersister", newsPersister);

        // 通过构造方法注入
        ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
        argumentValues.addIndexedArgumentValue(0, newsListener);
        argumentValues.addIndexedArgumentValue(1, newsPersister);
        newsProvider.setConstructorArgumentValues(argumentValues);

        // 通过setter方法注入
//        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
//        propertyValues.addPropertyValue(new PropertyValue("newPersister", newsPersister));
//        newsProvider.setPropertyValues(propertyValues);

        return (BeanFactory) registry;
    }
}
