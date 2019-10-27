package ststb;

import shared.ButtonMethod;
import shared.HelperBase;
import shared.HibernateHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

public class ControllerHelper extends HelperBase {

    protected boolean initialLoad = true;

    protected SellBook data = new SellBook();
    protected User userData = new User();

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
        props.setProperty("hibernate.connection.username", "username");
        props.setProperty("hibernate.connection.password", "password");

        boolean create = Boolean.parseBoolean(servlet.getInitParameter("create"));
        if (create)
            HibernateHelper.createTable(props, SellBook.class);
            HibernateHelper.createTable(props, User.class);

        HibernateHelper.initSessionFactory(props, SellBook.class);
        HibernateHelper.initSessionFactory(props, User.class);
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
    @ButtonMethod(buttonName = "loginButton")
    public String loginButtonMethod()
    {
        System.out.println("tracer from loginButton Method");
        return jspLocation("login/editLogin.jsp");
    }
    /* Jason */
    @ButtonMethod(buttonName = "loginConfirmButton")
    public String loginConfirmMethod() {
        fillBeanFromRequest(userData);
        setErrors(userData);
        /* The next JSP address depends on the validity of the data. */
        String address = jspLocation("login/editLogin.jsp");
        /* stores a copy of the password to be used below for validation */
        String tempPassword = userData.getPassword();
        /* use @ annotations in user.java to check for null and email type. if not,
             the return user to the editLogin.jsp page
        */ 
        if (isValidProperty("email") && isValidProperty("password") ) 
        { /* check to see if email exists in the user table. if yes, assign bean to 
            to Object dataPersistent. If no, then return user to editLogin.jsp 
          */
            Object dataPersistent = HibernateHelper.getFirstMatch(userData, "email" ,userData.getEmail() );
           /*  */
            if(dataPersistent != null)
            { /* we know know that dataPersistent contains a bean with the correct email now, 
                   we need to veriy the password. Assign the bean to userData then verify
                   the password.
              */
                userData = (User)dataPersistent;
                if( userData.getPassword().equals( tempPassword ) )
                {
                         java.util.List list =
                HibernateHelper.getListData(userData.getClass());
        request.setAttribute("database", list);
                    address = jspLocation("login/processLogin.jsp");
                }
                else
                {
                    address = jspLocation("login/editLogin.jsp");
                }   
            }
            clearErrors();
            
        } else {
            address = jspLocation("login/editLogin.jsp");
        }
    
        return address;
    }
    
    /* Jason */
    @ButtonMethod(buttonName = "loginSubmit")
    public String loginSubmitMethod()
    {System.out.println("tracer from loginSubmit Method");
    
    fillBeanFromRequest(userData);
    
        if (!isValid(userData)) {
            return jspLocation("Expired.jsp");
        }
        System.out.println("Tracer before - login method() HibernateHelper.updateDB(userData)");
        HibernateHelper.updateDB(userData);
        System.out.println("Tracer after - login method() HibernateHelper.updateDB(userData)");
        java.util.List list =
                HibernateHelper.getListData(userData.getClass());
        request.setAttribute("database", list);
        return jspLocation("login/processLogin.jsp");
    }
    
    /* Jason */
        @ButtonMethod(buttonName = "signupButton")
    public String signupButtonMethod()
    {
        System.out.println("tracer from signupButton Method");
         return jspLocation("signup/editSignUp.jsp");
    }
    /* Jason */
      @ButtonMethod(buttonName = "userConfirmButton")
    public String userConfirmMethod() {
        fillBeanFromRequest(userData);
        //The next JSP address depends on the validity of the data.
        String address;
        if (isValid(userData)) {
            address = jspLocation("signup/confirmSignUp.jsp");
        } else {
            address = jspLocation("signup/editSignUp.jsp");
        }
        return address;
    }
    /* Jason */
    @ButtonMethod(buttonName = "userProcessButton")
    public String userProcessMethod()
    {
    fillBeanFromRequest(userData);
    
        if (!isValid(userData)) {
            return jspLocation("Expired.jsp");
        }
        HibernateHelper.updateDB(userData);
        java.util.List list = HibernateHelper.getListData(userData.getClass());
        request.setAttribute("database", list);
        //return jspLocation("signup/processSignUp.jsp");
        return jspLocation("login/processLogin.jsp");
    }
    /* Jason */
    @ButtonMethod(buttonName = "userEditButton")
    public String userEditMethod()
    {
        return jspLocation("signup/editSignUp.jsp");
    }
    
    
    
    

    @Override
    public void doGet() throws ServletException, java.io.IOException
    {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.IGNORE);

        //Modify to test pages
        //String address = initialLoad();
        String address = editMethod();

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
