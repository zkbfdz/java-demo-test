package com.zhukai.practise.bean;

/**
 * Created by kai.zhu on 2018/9/14/014.
 */
public class DowJonesNewsListener implements IFXNewsListener {
    @Override
    public void postProcessIfNecessary(String newsId) {
        System.out.println(newsId);
    }

    @Override
    public String[] getAvailableNewsIds() {
        return new String[]{"DowJonesNewsListener"};
    }

    @Override
    public FXNewsBean getNewsByPK(String newsId) {
        FXNewsBean fxNewsBean = new FXNewsBean();
        fxNewsBean.setContent("hahahah");
        return fxNewsBean;
    }
}
