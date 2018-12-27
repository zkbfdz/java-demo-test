package springjiemi.beanFactoryDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import springjiemi.bean.FXNewsProvider;

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
}
