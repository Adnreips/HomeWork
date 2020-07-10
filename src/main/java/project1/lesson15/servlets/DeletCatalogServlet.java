package project1.lesson15.servlets;

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
@WebServlet(urlPatterns = "/deletproduct")
public class DeletCatalogServlet extends HttpServlet {
    @Inject
    private CatalogDao catalogDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("PageTitle", "Delete product");
        request.setAttribute("PageBody", "form1.jsp");
        String tovarId = request.getParameter("id");
        if (tovarId == null) {
            throw new ServletException("Missing parameter id");
        }
        Boolean product = catalogDao.deleteCatalogById(Integer.valueOf(tovarId));

        response.sendRedirect(request.getContextPath() + "/catalog");
    }
}
