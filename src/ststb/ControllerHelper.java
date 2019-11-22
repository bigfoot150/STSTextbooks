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
        //props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");  //older MYSQL driver class
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

        HibernateHelper.initSessionFactory(props, SellBook.class);
    }

    public Object getData() { return data; }

    protected void copyFromSession(Object sessionHelper)
    {
        if (sessionHelper.getClass() == this.getClass())
            data = ((ControllerHelper) sessionHelper).data;
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
