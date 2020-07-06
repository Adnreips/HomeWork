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
@WebServlet(urlPatterns = "/showcatalog")
public class ShowCatalogServlet extends HttpServlet {

    @Inject
    private CatalogDao catalogDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tovarId = request.getParameter("id");
        if (tovarId == null) {
            throw new ServletException("Missing parameter id");
        }

        Catalog tovar = catalogDao.getCatalogById(Integer.valueOf(tovarId));
        if (tovar == null) {
            response.setStatus(404);
            request.getRequestDispatcher("WEB-INF/jsp/notfound.jsp").forward(request, response);
            return;
        }

        request.setAttribute("model", tovar);
        request.getRequestDispatcher("WEB-INF/jsp/showcatalog.jsp").forward(request, response);
    }
}
