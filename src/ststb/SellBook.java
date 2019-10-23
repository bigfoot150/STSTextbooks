package ststb;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class SellBook extends shared.PersistentBase implements Serializable
{
    protected String isbn13;
    protected String isbn10;
    protected String userid;
    protected String date_created;
    protected String author;
    protected String title;
    protected float  price;
    protected float  shipping_cost;
    protected String quantity;


    public SellBook()    {}

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

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getShipping_cost() {
        return shipping_cost;
    }

    public void setShipping_cost(float shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    //    @Pattern(regexp=".*\\S.*", message="Cannot be empty")
//    @NotNull
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    @Pattern(regexp=".*\\S.*", message="Cannot be empty")
//    @NotNull
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    @Min(value=15, message="Must be at least 15 yrs old.")
//    @Max(value=115, message="Cannot be greater than 115 years old.")
//    public int getAge()
//    {
//        return age;
//    }
//
//    public void setAge(int age)
//    {
//        this.age = age;
//    }
//
//    @Email(message = "Must be in address@domain format")
//    @Pattern(regexp=".*\\S.*", message="Cannot be empty")
//    @NotNull
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
