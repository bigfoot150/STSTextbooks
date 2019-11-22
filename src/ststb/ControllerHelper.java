package ststb;

import shared.ButtonMethod;
import shared.HelperBase;
import shared.HibernateHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.util.Properties;

public class ControllerHelper extends HelperBase {

    protected boolean initialLoad = true;

    private CatalogueItem data = new CatalogueItem();
    private CatalogueItem item = new CatalogueItem();
    private ShoppingCart<CatalogueItem> cart = new ShoppingCart<CatalogueItem>();

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    static public void initHibernate(HttpServlet servlet) {
//        Properties props = new Properties();
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        props.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver"); //My SQL8 driver class
//        //props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");  //older MYSQL driver class
//        props.setProperty("hibernate.c3p0.min_size", "1");
//        props.setProperty("hibernate.c3p0.max_size", "5");
//        props.setProperty("hibernate.c3p0.timeout", "300");
//        props.setProperty("hibernate.c3p0.max_statements", "50");
//        props.setProperty("hibernate.c3p0.idle_test_period","300");
//
//        //The following properties must be updated with your information.
//        //Replace the capitalized words with your database information.
//        //The standard port for MySQL is 3306.
//        props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ststb");
//        props.setProperty("hibernate.connection.username", "username");
//        props.setProperty("hibernate.connection.password", "password");

        Boolean create = Boolean.parseBoolean(servlet.getInitParameter("create"));

        if (create)
        {
            HibernateHelper.createTable(
                    ShoppingCart.class,
                    CatalogueItem.class);
        }
        HibernateHelper
                .initSessionFactory(
                        ShoppingCart.class,
                        CatalogueItem.class);
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
    public String loginMethod() {
        String address;
        fillBeanFromRequest(cart);
        setErrors(cart);
        if (isValidProperty("accountNumber")) {
            Object dataPersistent = HibernateHelper.getFirstMatch(cart,"accountNumber", cart.getAccountNumber());
            if (dataPersistent != null)
            {
                cart = (ShoppingCart<CatalogueItem>)dataPersistent;
            }
            clearErrors();
            address = methodBrowseLoop();
        } else {
            address = jspLocation("Login.jsp");
        }
        return address;
    }

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
