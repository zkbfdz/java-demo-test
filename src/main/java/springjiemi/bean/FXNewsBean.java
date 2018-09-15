package springjiemi.bean;

/**
 * Created by kai.zhu on 2018/9/14/014.
 */
public class FXNewsBean {

    private String newId;

    private String content;

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FXNewsBean{" +
                "newId=" + newId +
                ", content='" + content + '\'' +
                '}';
    }
}
