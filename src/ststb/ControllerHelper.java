
package ststb;

import shared.ButtonMethod;
import shared.HelperBase;
import shared.HibernateHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;
import shared.CookieUtil;

public class ControllerHelper extends HelperBase {

    protected boolean initialLoad = true;

    private CatalogueItem data = new CatalogueItem();
    private CatalogueItem item = new CatalogueItem();
    private ShoppingCart<CatalogueItem> cart = new ShoppingCart<CatalogueItem>();
    protected UserProfile userData = new UserProfile();

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    static public void initHibernate(HttpServlet servlet) {

        Boolean create = Boolean.parseBoolean(servlet.getInitParameter("create"));

        if (create)
        {
            HibernateHelper.createTable(
                    ShoppingCart.class,
                    CatalogueItem.class, UserProfile.class);
        }
        HibernateHelper
                .initSessionFactory(
                        ShoppingCart.class,
                        CatalogueItem.class, UserProfile.class);
        if (create)
            CreateCatalogue.createCatalogue();
    }

    public Object getData() { return data; }

    public void copyFromSession(Object sessionHelper)
    {
        if (sessionHelper.getClass() == this.getClass())
        {
            item = ((ControllerHelper)sessionHelper).item;
            cart = ((ControllerHelper)sessionHelper).cart;
            data = ((ControllerHelper) sessionHelper).data;
        }
    }

    protected String jspLocation(String page)
    {
        return "/WEB-INF/classes/ststb/" + page;
    }

    @ButtonMethod(buttonName = "selleditButton")
    public String editMethod()
    {
        return jspLocation("sell/edit.jsp");
    }

    @ButtonMethod(buttonName = "sellconfirmButton")
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

    @ButtonMethod(buttonName = "sellprocessButton")
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

    @ButtonMethod(buttonName="saveCart")
    public String saveCartMethod() {
        methodProcess();
        HibernateHelper.updateDB(cart);
        return jspLocation("SaveCart.jsp");
    }

    public Object getItem() {
        return item;
    }

    public Object getCart() {
        return cart;
    }


    @ButtonMethod(buttonName="buyButton")
    public String methodBrowseLoop() {
        //Make all the catalog items available from the browseloop.jsp.
        java.util.List list = HibernateHelper
                .getListData(item.getClass());
        request.setAttribute("allItems", list);
        return jspLocation("buy/browseloop.jsp");
    }

    @ButtonMethod(buttonName="addCart")
    public String methodAddCart() {
        cart.addItem(item);
        item = new CatalogueItem();
        return methodBrowseLoop();
    }

    @ButtonMethod(buttonName="emptyCart")
    public String methodEmptyCart() {
        cart.resetItems();
        return methodBrowseLoop();
    }

    @ButtonMethod(buttonName="viewItem")
    public String methodViewItem() {
        fillBeanFromRequest(item);
        if (item.getItemid() != null) {
            Object dbObj = HibernateHelper.
                    getFirstMatch(item, "itemid",
                            item.getItemid());
            if (dbObj != null) {
                item = (CatalogueItem)dbObj;
            }
        }
        return methodBrowseLoop();
    }

    @ButtonMethod(buttonName="shoppingcartButton")
    public String methodViewCart() {
        return jspLocation("shoppingcart/Cart.jsp");
    }

    @ButtonMethod(buttonName="faqButton")
    public String faqMethod() {
        return jspLocation("faq.html");
    }

    @ButtonMethod(buttonName="helpButton")
    public String helpMethod() {
        return jspLocation("help.html");
    }

    @ButtonMethod(buttonName="processCart")
    public String methodProcess() {
        cart.setTotal(0);
        cart.setCount(0);
        for(Object anObject : cart.getItems()) {
            CatalogueItem anItem =
                    (CatalogueItem)anObject;
            cart.addTotal(anItem.getPrice());
            cart.incrCount();
        }
        return jspLocation("shoppingcart/Process.jsp");
    }

    @SuppressWarnings("unchecked")
    @ButtonMethod(buttonName="loginButton", isDefault=true)
    public String loginButtonMethod(){
        String address = "login/editLogin.jsp";
        Cookie accountCookie = CookieUtil.findCookie(request, "email");
        if (accountCookie != null) {
            Object dataPersistent = HibernateHelper.getFirstMatch(userData,"email", accountCookie.getValue());
            if (dataPersistent != null)
            {
                userData = (UserProfile) dataPersistent;
            }
            address = "login/editLogin.jsp";

        }
        else {
            address = jspLocation("Login.jsp");
        }
        return jspLocation(address);
    }

//    public String loginMethod() {
//        String address;
//        fillBeanFromRequest(cart);
//        setErrors(cart);
//        if (isValidProperty("accountNumber")) {
//            Object dataPersistent = HibernateHelper.getFirstMatch(cart,"accountNumber", cart.getAccountNumber());
//            if (dataPersistent != null)
//            {
//                cart = (ShoppingCart<CatalogueItem>)dataPersistent;
//            }
//            clearErrors();
//            address = methodBrowseLoop();
//        } else {
//            address = jspLocation("Login.jsp");
//        }
//        return address;
//    }

    @ButtonMethod(buttonName = "processLoginButton")
    public String processLoginButtonMethod()
    {
        return jspLocation("login/processLogin.jsp");
    }

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




///////////////////////////////////////////////////////////////////////////
    @Override
    public void doGet() throws ServletException, java.io.IOException
    {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.IGNORE);

        //Modify to test pages
        //String address = initialLoad();
        //String address = editMethod();
        String address = executeButtonMethod();

        request.getRequestDispatcher(address).forward(request, response);
    }

    @Override
    public void doPost() throws ServletException, IOException
    {
        addHelperToSession("helper", SessionData.READ);
        String address = executeButtonMethod();
        request.getRequestDispatcher(address).forward(request, response);
    }



}
