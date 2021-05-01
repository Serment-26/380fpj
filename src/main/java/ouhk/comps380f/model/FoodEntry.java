package ouhk.comps380f.model;
import java.io.Serializable;
import java.util.Date;
public class FoodEntry implements Serializable {
    Integer itemid;
    String itemname;
    Integer photo;
    Double price;
    Boolean selling;
    public Integer getItemid() {
        return itemid;
    }
    public String getItemname() {
        return itemname;
    }
    public Integer getPhoto() {
        return photo;
    }
    public Double getPrice() {
        return price;
    }
    public Boolean getSelling() {
        return selling;
    }
    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    public void setPhoto(Integer photo) {
        this.photo = photo;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setSelling(Boolean selling) {
        this.selling = selling;
    }
}
