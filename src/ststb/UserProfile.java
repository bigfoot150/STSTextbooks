package ststb;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;
/*
 * @author Jason
 */
@Entity
public class UserProfile extends shared.PersistentBase implements Serializable{
    
    /* UserProfile table columns  */
    private String first_name;
    private String last_name;
    private String primary_address;
    private String city;
    private String state_abbr;
    private String zip_code;
    private String phone;
    private String email;
    private String username;
    private String password;
    /* these three variables are used for storing error messages during login and signup */

    private transient String email_error_message;

    private transient String password_error_message;

    private transient String username_error_message;

    private transient String misc_error_message;

    private transient Boolean authenticated = false;
    
    /* constructor, to be user for batch populating of userProfile table */
    public UserProfile(String first_name, String last_name, String primary_address,
            String city, String state_abbr, String zip_code,
            String phone, String email, String username, String password){
        this.first_name = first_name;
        this.last_name = last_name;
        this.primary_address = primary_address;

        this.city = city;
        this.state_abbr = state_abbr;
        this.zip_code = zip_code;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public UserProfile()    {
        this("", "", "", "", "", "","","","","");
    }

    /*    begin login table columns */
    @NotBlank
    @Email(message = "please enter a valid email")
    @Column(unique = true) /* only helps hibernate design schema. otherwise induces runtime error. */    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @NotBlank
    @Column(unique = true)
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @NotBlank
    @Length(min=5,max=10,message="Password length must between 5-10 characters")
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }  
    @NotBlank
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    @NotBlank
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    @NotBlank
    public String getPrimary_address() {
        return primary_address;
    }

    public void setPrimary_address(String primary_address) {
        this.primary_address = primary_address;
    }
    
    @NotBlank
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    @NotBlank 
    @Pattern(regexp="[a-zA-Z][a-zA-Z]", message="State field must be exactly two characters")
    public String getState_abbr() {
        return state_abbr;
    }

    public void setState_abbr(String state_abbr) {
        this.state_abbr = state_abbr;
    }
    @NotBlank
    @Pattern(regexp="\\d{5}(?:-\\d{4})?", message="pattern must be 12345 or 12345-6789")
    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
    
    @Pattern(regexp="(\\d{10})?", message="phone number format is 0123456789 or empty")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
     /* custom error message holders. Assigned in the login confirm
        and signin confirm methods in the controllerHelper */
    @Transient
    public String getEmail_error_message() {
        return email_error_message;
    }

    public void setEmail_error_message(String msg) {
        this.email_error_message = msg;
    }

    @Transient
    public String getPassword_error_message() {
        return password_error_message;
    }

    public void setPassword_error_message(String msg) {
        this.password_error_message = msg;
    }   

    @Transient
    public String getUsername_error_message() {
        return username_error_message;
    }

    public void setUsername_error_message(String msg) {
        this.username_error_message = msg;
    }

    @Transient
    public String getMisc_error_message() {
        return misc_error_message;
    }

    public void setMisc_error_message(String msg) {
        this.misc_error_message = msg;
    }  

    @Transient
    public Boolean getAuthenticated() {return authenticated;}

    public void setAuthenticated(Boolean authenticated) {this.authenticated = authenticated;}
}
