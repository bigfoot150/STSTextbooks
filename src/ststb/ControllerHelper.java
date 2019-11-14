package ststb;

import shared.ButtonMethod;
import shared.HelperBase;
import shared.HibernateHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.servlet.http.Cookie;
import shared.CookieUtil;

public class ControllerHelper extends HelperBase {

    protected boolean initialLoad = true;

    protected SellBook data = new SellBook();
    protected UserProfile userData = new UserProfile();

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    static public void initHibernate(HttpServlet servlet) {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver"); //My SQL8 driver class
        props.setProperty("hibernate.c3p0.min_size", "1");
        props.setProperty("hibernate.c3p0.max_size", "5");
        props.setProperty("hibernate.c3p0.timeout", "300");
        props.setProperty("hibernate.c3p0.max_statements", "50");
        props.setProperty("hibernate.c3p0.idle_test_period","300");

        //The following properties must be updated with your information.
        //Replace the capitalized words with your database information.
        //The standard port for MySQL is 3306.
        props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ststb");
        props.setProperty("hibernate.connection.username", "root");
        props.setProperty("hibernate.connection.password", "Garsha123!");

        boolean create = Boolean.parseBoolean(servlet.getInitParameter("create"));
        if (create){
            HibernateHelper.createTable(props, SellBook.class);
            HibernateHelper.createTable(props, UserProfile.class);
    }
        HibernateHelper.initSessionFactory(props, SellBook.class);
        HibernateHelper.initSessionFactory(props, UserProfile.class);
        }

    public Object getData() { return data; }
    public Object getUserData() { return userData; }

    protected void copyFromSession(Object sessionHelper)
    {
        if (sessionHelper.getClass() == this.getClass()){
            data = ((ControllerHelper) sessionHelper).data;
            userData = ((ControllerHelper) sessionHelper).userData;
        }
    }
    
    protected String jspLocation(String page)
    {
        return "/WEB-INF/classes/ststb/" + page;
    }

    public String initialLoad()
    {
        return jspLocation("sell/edit.jsp");
    }


//    @ButtonMethod(buttonName = "submitButton")
//    public String submitMethod()
//    {
//        fillBeanFromRequest(data);
//        if (!isValid(data))
//            return jspLocation("sell/edit.jsp");
//
//        HibernateHelper.updateDB(data);
//        java.util.List list = HibernateHelper.getListData(data.getClass());
//        request.setAttribute("database", list);
//        return jspLocation("sell/process.jsp");
//
//    }

    @ButtonMethod(buttonName = "editButton", isDefault = true)
    public String editMethod()
    {
        return jspLocation("sell/edit.jsp");
    }

    @ButtonMethod(buttonName = "confirmButton")
    public String confirmMethod() {
        fillBeanFromRequest(data);
        //The next JSP address depends on the validity of the data.
        String address;
        if (isValid(data)) {
            address = jspLocation("sell/confirm.jsp");
        } else {
            address = jspLocation("sell/edit.jsp");
        }
        return address;
    }

    @ButtonMethod(buttonName = "processButton")
    public String processMethod()
    {
        if (!isValid(data)) {
            return jspLocation("Expired.jsp");
        }
        HibernateHelper.updateDB(data);
        java.util.List list =
                HibernateHelper.getListData(data.getClass());
        request.setAttribute("database", list);
        return jspLocation("sell/process.jsp");
    }

    /* Jason */
    //@Override
    @ButtonMethod(buttonName="loginButton")
    public String loginButtonMethod(){
      String address = "login/editLogin.jsp";
        Cookie accountCookie =
                CookieUtil.findCookie(request, "email");
        if (accountCookie != null) {
            Object dataPersistent = HibernateHelper.getFirstMatch(userData,
                    "email",
                    accountCookie.getValue());
            if (dataPersistent != null) {
                userData = (UserProfile) dataPersistent;
            }
            address = "login/editLogin.jsp";
        }
        return jspLocation(address);    
    }

    /* Jason */ 
    @ButtonMethod(buttonName = "processLoginButton")
    public String processLoginButtonMethod()
    {
        return jspLocation("login/processLogin.jsp");
    }
    
    /* Jason */
    @ButtonMethod(buttonName = "loginConfirmButton")
    public String loginConfirmMethod() {
        //fill the new bean with the form elements from editLogin.jsp
        fillBeanFromRequest(userData);
        // populate the error map
        setErrors(userData);
        // set custom error message handelers to null
        userData.setEmail_error_message(null);
        userData.setPassword_error_message(null);
        userData.setMisc_error_message(null);
        /* set default jsp location */
        String address = jspLocation("login/editLogin.jsp");
        /* Store a copy of the password that the user has submitted. */
        String tempPassword = userData.getPassword();
        /* use @ annotations in userProfile.java to check for null and email syntax type. If invalid,
             then return user to the editLogin.jsp page */        
        if (isValidProperty("email") && isValidProperty("password") ) 
        { /* check to see if the email submitted by the user exists in the user table. If yes, assign bean to 
             to Object result continue to password check. If no, then return user to editLogin.jsp */
            Object result = HibernateHelper.getFirstMatch(userData, "email" ,userData.getEmail() );
            if(result != null)
            { /* we know know that result contains an object with an email that exists in the database. 
                 Now, verify the password associated with that object. Assign result to userData,
                retrieve the associated password from the database and then verify against 
                the tempPassword stored earlier. */               
                userData = (UserProfile)result;
                if( userData.getPassword().equals( tempPassword ) )
                {/* If password matches, send user to processLogin.jsp.
                    Else, send user to editLogin.jsp */
                    java.util.List list =
                        HibernateHelper.getListData(userData.getClass());
                    request.setAttribute("database", list);
                    address = jspLocation("login/processLogin.jsp");
                }
                else
                {   /* notify user that password does not match given email. Send user to editLogin.jsp */ 
                    userData.setPassword_error_message("password does not match");
                    address = jspLocation("login/editLogin.jsp");
                }   
            }
            clearErrors();
        } else {
            address = jspLocation("login/editLogin.jsp");
        }
         /* Notify user that the email or password is not a valid format. */
            userData.setEmail_error_message("Email not found");
        return address;
    }
    
    /* Jason */
    @ButtonMethod(buttonName = "loginSubmit")
    public String loginSubmitMethod()
    {
        fillBeanFromRequest(userData);
        if (!isValid(userData)) {
            return jspLocation("Expired.jsp");
        }
        HibernateHelper.updateDB(userData);
        java.util.List list =
                HibernateHelper.getListData(userData.getClass());
        request.setAttribute("database", list);
        return jspLocation("login/processLogin.jsp");
    }
    
    /* Jason */
        @ButtonMethod(buttonName = "signupButton")
    public String signupButtonMethod()
    {
        userData.setEmail_error_message(null);
        userData.setPassword_error_message(null);
        userData.setMisc_error_message(null);
        return jspLocation("signup/editSignUp.jsp");
    }
    /* Jason */
      @ButtonMethod(buttonName = "userConfirmButton")
    public String userConfirmMethod() {
        fillBeanFromRequest(userData);
        //The next JSP address depends on the validity of the data.
        String address;
        /* Always reset custom error messages to null */
        userData.setEmail_error_message(null);
        userData.setPassword_error_message(null);
        userData.setMisc_error_message(null);
        /* Check to see if the email and/or username requested by the user are already taken.
            If yes, assign appropriate error messages and return user to editSignUp.jsp */
         Object result = HibernateHelper.getFirstMatch(userData, "email" ,userData.getEmail() );
         Object result2 = HibernateHelper.getFirstMatch(userData, "username" ,userData.getUsername() );
         if(result != null){userData.setEmail_error_message("That email is not available");}
         if(result2 != null){userData.setUsername_error_message("That username is not available");}
           /* If email and username are unique and errors map is clear, then send user to confirmSignUp.jsp */
        if (isValid(userData) && result == null && result2 == null) {
            address = jspLocation("signup/confirmSignUp.jsp");
        }
        else { /* if email and/or username are not unique or there are errors in the error map then
                send user to editSignUp.jsp */
            address = jspLocation("signup/editSignUp.jsp");
        }
        return address;
    }

    @ButtonMethod(buttonName = "userProcessButton")
    public String userProcessMethod()
    {
    fillBeanFromRequest(userData);
        if (!isValid(userData)) {
            return jspLocation("Expired.jsp");
        }
        //response.addCookie(new Cookie("email", userData.getEmail()));
        Cookie email = new Cookie("email", userData.getEmail());
        email.setMaxAge(31536000); /* 86400 seconds per day x 365 days a year. */
        response.addCookie(email);
        HibernateHelper.updateDB(userData);
        java.util.List list = HibernateHelper.getListData(userData.getClass());
        request.setAttribute("database", list);
        return jspLocation("login/processLogin.jsp");
    }
    
    /* Jason */
    @ButtonMethod(buttonName = "userEditButton")
    public String userEditMethod()
    {
        return jspLocation("signup/editSignUp.jsp");
    }
    /* Jason */
    @ButtonMethod(buttonName = "editProfileButton")
    public String editProfileMethod()
    {
        return jspLocation("login/editProfile.jsp");
    }
    
    /* Jason */
      @ButtonMethod(buttonName = "updateProfileButton")
    public String updateProfileMethod() {
        String address = jspLocation("login/editProfile.jsp");
        /* Always reset custom error message values to null */
        userData.setEmail_error_message(null);
        userData.setPassword_error_message(null);
        userData.setMisc_error_message(null);
        Object result2 = HibernateHelper.getFirstMatch(userData, "email", userData.getEmail() );
        Object result = null;
        /* check and see if user is requesting a new username. If yes, then verify that
           it is available. This must be completed before fillBearnFromRequest() because
            username is a unique field and attempting to assign a duplicate will
            throw an un-recoverable error. */
            if(!userData.getUsername().equals(request.getParameter("username"))){
            result = HibernateHelper.getFirstMatch(userData, "username", request.getParameter("username"));
            }         
            if(result == null){
                /* Once here, the requested username is available, fill the bean with all the data
                   from the editProfile submission and validate data integrity. */
                fillBeanFromRequest(userData);
                setErrors(userData);
                /* verify all fields conform to restrictions. */
                if(isValid(userData)){
                        HibernateHelper.updateDB(userData);
                        java.util.List list = HibernateHelper.getListData(userData.getClass());
                        request.setAttribute("database", list);
                        userData.setMisc_error_message("Profile successfully updated!");
                    return address;
                }
                /* userData validation found errors. Since data is invalid we must reset
                   the bean to the state before calling fillbeanfromrequest(). Otherwise,
                   bean will have incorrect data.
                   */
                if(result2 != null){
                    userData = (UserProfile)result2;
                    return address;                   
                }    
            }
        userData.setUsername_error_message("That username is not available");
        return address;
    }
    
    
    
    

    @Override
    public void doGet() throws ServletException, java.io.IOException
    {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.IGNORE);

        //Modify to test pages
        //String address = initialLoad();
        String address = editMethod();
        if(   request.getParameter("userSignOutButton") != null ){
            address = loginButtonMethod();
            }
        request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    public void doPost() throws ServletException, java.io.IOException
    {
        addHelperToSession("helper", SessionData.READ);
        String address = executeButtonMethod();
        request.getRequestDispatcher(address).forward(request, response);
    }
}
