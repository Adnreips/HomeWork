package project1.lesson15.servlets;

import project1.lesson15.catalog.Catalog;
import project1.lesson15.dao.CatalogDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AddCatalogServlet
 *
 * @author "Andrei Prokofiev"
 */

@WebServlet(urlPatterns = "/addproduct")
public class AddCatalogServlet extends HttpServlet {

    @Inject
    private CatalogDao catalogDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("PageTitle", "New product");
        request.setAttribute("PageBody", "form.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String nameProduct = request.getParameter("nameProduct");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        Catalog product = new Catalog(null, nameProduct, Integer.valueOf(price), manufacturer);
        catalogDao.addCatalog(product);

        response.sendRedirect(request.getContextPath() + "/catalog");
    }

}
