
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

    static final List<CatalogueItem> itemList =
            new ArrayList<CatalogueItem>();

    static {
        itemList.add(new CatalogueItem(
                "A1", "The Foundation Trilogy",
                "A very fine book. Why not buy one?", 1.11));
        itemList.add(new CatalogueItem(
                "T2", "The Hobbit",
                "A very fine book. Why not buy two?", 2.22));
        itemList.add(new CatalogueItem(
                "Y3", "Light on Yoga",
                "A very fine book. Why not buy three?", 3.33));
        itemList.add(new CatalogueItem(
                "M4", "Blue Monkey Sideshow",
                "A very fine book. Why not buy four?", 4.44));
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
