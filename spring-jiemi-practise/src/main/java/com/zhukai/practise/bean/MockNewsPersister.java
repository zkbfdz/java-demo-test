package com.zhukai.practise.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class MockNewsPersister implements IFXNewsPersister, BeanFactoryAware {

    private FXNewsBean newsBean;

    private BeanFactory beanFactory;

    public FXNewsBean getNewsBean () {
        return (FXNewsBean) beanFactory.getBean("newsBean");
    }

    public void setNewsBean(FXNewsBean newsBean) {
        this.newsBean = newsBean;
    }

    @Override
    public void persistNews(FXNewsBean newsBean) {
        persistNews();
    }

    public void persistNews() {
        System.out.println("persist bean + " + getNewsBean());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
