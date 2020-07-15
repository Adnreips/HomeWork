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
 * ${NAME}
 *
 * @author "Andrei Prokofiev"
 */
@WebServlet(urlPatterns = "/catalog/showcatalog")
public class ShowCatalogServlet extends HttpServlet {

    @Inject
    private CatalogDao catalogDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tovarId = request.getParameter("id");
        if (tovarId == null) {
            throw new ServletException("Missing parameter id");
        }

        Catalog product = catalogDao.getCatalogById(Integer.valueOf(tovarId));
        if (product == null) {
            response.setStatus(404);
//            request.getRequestDispatcher("WEB-INF/jsp/notfound.jsp").forward(request, response);
            request.setAttribute("PageTitle", "Product");
            request.setAttribute("PageBody", "notfound.jsp");
            request.getRequestDispatcher("/layout.jsp")
                    .forward(request, response);

            return;
        }

//        request.setAttribute("model", product);
//        request.getRequestDispatcher("WEB-INF/jsp/showcatalog.jsp").forward(request, response);
        request.setAttribute("product", product);
        request.setAttribute("PageTitle", "Product");
        request.setAttribute("PageBody", "showcatalog.jsp");
        request.getRequestDispatcher("/layout.jsp")
                .forward(request, response);
    }
}
