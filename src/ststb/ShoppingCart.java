package ststb;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class ShoppingCart<Item>
        extends shared.PersistentBase implements Serializable {


    private static NumberFormat currency = NumberFormat.getCurrencyInstance();
    private double total;
    private int count;
    private String email;

    public ShoppingCart() {
        resetItems();
    }

    public final void resetItems() {
        items = new ArrayList<CatalogueItem>();
        total = 0.0;
        count = 0;
    }

    public void addItem(CatalogueItem item) {
        items.add(item);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void addTotal(double amount) {
        total += amount;
    }

    @Transient
    public String getTotalAsCurrency() {
        return currency.format(total);
    }

    public void incrCount() {
        count++;
    }

    protected String accountNumber;

    @Pattern(regexp="[a-zA-Z]{2}\\d{3}",
            message="must be in the format AA999.")
    @NotNull
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @NotBlank
    @Email(message = "please enter a valid email")
    @Column(unique = true) /* only helps hibernate design schema. otherwise induces runtime error. */  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected List<CatalogueItem> items;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    public List<CatalogueItem> getItems() {
        return items;
    }

    public void setItems(List<CatalogueItem> items) {
        this.items = items;
    }
}
