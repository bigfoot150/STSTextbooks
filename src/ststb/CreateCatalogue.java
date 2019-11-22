
package ststb;

import shared.HibernateHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns={"/ststb/CreateCatalogue"})
public class CreateCatalogue extends HttpServlet {

    @Override
    public void init() {
        HibernateHelper.createTable(CatalogueItem.class);
        HibernateHelper.initSessionFactory(CatalogueItem.class);
    }

    static final List<CatalogueItem> itemList = new ArrayList<CatalogueItem>();

    static {
        itemList.add(new CatalogueItem(
                "A1", "The Foundation Trilogy",
                "A very fine book. Why not buy one?", 1.11, "978-1607962748", "1607962748", "system", "Issac Asimov", 5.00, 10));
        itemList.add(new CatalogueItem(
                "T2", "The Hobbit",
                "A very fine book. Why not buy two?", 2.22, "978-0261102002", "0261102001", "system", "J. R. R. Tolkien", 5.00, 5));
        itemList.add(new CatalogueItem(
                "Y3", "Light on Yoga",
                "A very fine book. Why not buy three?", 3.33, "978-0805210316", "0805210318", "system", "B. K. S. Iyengar", 5.00, 6));
        itemList.add(new CatalogueItem(
                "M4", "Programming: Principles and Practice Using C++",
                "An Introduction to Programming by the Inventor of C++", 4.44, "978-0321992789", "0321992784", "system", "Bjarne Stroustrup", 5.00, 6 ));
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HibernateHelper.updateDB(itemList);
        response.getWriter().print("Persistent Catalogue Created");
        destroy();

    }

    @SuppressWarnings("unchecked")
    public static void createCatalogue() {
        List<CatalogueItem> itemsDB = (List<CatalogueItem>)
                HibernateHelper.getListData(CatalogueItem.class);
        for (CatalogueItem item : itemsDB) {
            HibernateHelper.removeDB(item);
        }
        HibernateHelper.updateDB(itemList);
    }
}
