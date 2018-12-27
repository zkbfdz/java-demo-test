package com.zhukai.practise.bean;

/**
 * Created by kai.zhu on 2018/9/14/014.
 */
public class DowJonesNewsPersister implements IFXNewsPersister {
    @Override
    public void persistNews(FXNewsBean newsBean) {
        System.out.println("DowJonesNewsPersister.persistNews");
    }
}
