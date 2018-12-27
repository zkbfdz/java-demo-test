package com.zhukai.practise.bean;

/**
 * Created by kai.zhu on 2018/9/14/014.
 */
public interface IFXNewsListener {

    public void postProcessIfNecessary(String newsId);

    public String[] getAvailableNewsIds();

    public FXNewsBean getNewsByPK(String newsId);
}
