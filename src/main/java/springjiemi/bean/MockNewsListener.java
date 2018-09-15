package springjiemi.bean;

/**
 * Created by kai.zhu on 2018/9/14/014.
 */
public class MockNewsListener implements IFXNewsListener {
    @Override
    public void postProcessIfNecessary(String newsId) {
    }

    @Override
    public String[] getAvailableNewsIds() {
        return new String[0];
    }

    @Override
    public FXNewsBean getNewsByPK(String newsId) {
        return null;
    }
}
