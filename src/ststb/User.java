package ststb;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SecondaryTable;
import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Jason
 */
@Entity

public class User extends shared.PersistentBase implements Serializable{
    
    /////     User table columns     /////
    protected String first_name;
    protected String last_name;
    protected String primary_address;
    protected String secondary_address;
    protected String city;
    protected String state_abbr;
    protected String zip_code;
    protected String phone;
   
    protected String email;
    protected String username;
    protected String password;
    
    
    public User()    {}

    /////     begin login table columns     /////
    @NotBlank
    @Email(message = "please enter a valid email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @NotBlank
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @NotBlank
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }  
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public String getPrimary_address() {
        return primary_address;
    }

    public void setPrimary_address(String primary_address) {
        this.primary_address = primary_address;
    }
    
    public String getSecondary_address() {
        return secondary_address;
    }

    public void setSecondary_address(String secondary_address) {
        this.secondary_address = secondary_address;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState_abbr() {
        return state_abbr;
    }

    public void setState_abbr(String state_abbr) {
        this.state_abbr = state_abbr;
    }
    
    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
