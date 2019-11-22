
package ststb;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class CatalogueItem extends shared.PersistentBase implements Serializable {

    public CatalogueItem() {
        this(null, "", "", 0.00, "",
                "", "", "", 0.00, 0);
    }

    private String title;
    private String description;
    private String itemid;
    private double price;

    private String isbn13;
    private String isbn10;
    private String userid;
    private String author;
    private double shipping_cost;
    private int quantity;

    public CatalogueItem(String itemid, String name, String description, double price, String isbn13, String isbn10,
                         String userid, String author, double shipping_cost, int quantity)
    {
        this.itemid = itemid;
        this.title = name;
        this.description = description;
        this.price = price;
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.userid = userid;
        this.author = author;
        this.shipping_cost = shipping_cost;
        this.quantity = quantity;
    }

    @Length(min=1,max=50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Lob
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Length(min=1,max=10)
    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getShipping_cost() {
        return shipping_cost;
    }

    public void setShipping_cost(double shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
