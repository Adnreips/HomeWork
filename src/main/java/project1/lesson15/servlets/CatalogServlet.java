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
import java.io.PrintWriter;
import java.util.List;

/**
 * ${NAME}
 *
 * @author "Andrei Prokofiev"
 */
@WebServlet(urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {

    @Inject
    private CatalogDao catalogDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Catalog> catalog = catalogDao.getAllCatalog();
        request.setAttribute("catalog", catalog);
        request.setAttribute("PageTitle", "Catalog");
        request.setAttribute("PageBody", "catalog.jsp");
//        request.getRequestDispatcher("WEB-INF/jsp/catalog.jsp").forward(request, response);
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
