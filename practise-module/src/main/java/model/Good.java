package model;

/**
 * Created by kai.zhu on 2018/8/7/007.
 */
public class Good {

    private String name;

    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Good(String name, Double price) {
        this.name = name;
        this.price = price;
    }

}
