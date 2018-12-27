package springjiemi.bean;

import org.apache.commons.lang.ArrayUtils;

/**
 * Created by kai.zhu on 2018/9/13/013.
 */

public class FXNewsProvider {

    private IFXNewsListener newsListener;
    private IFXNewsPersister newPersistener;

    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newPersister) {
        this.newsListener = newsListener;
        this.newPersistener = newPersister;
    }

    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvailableNewsIds();
        if (ArrayUtils.isEmpty(newsIds)) {
            return;
        }
        for (String newsId : newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newPersistener.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
    }
}