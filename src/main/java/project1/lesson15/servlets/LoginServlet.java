package project1.lesson15.servlets;

import project1.lesson15.client.ClientServes;
import project1.lesson15.connection.ConnectionManager;
import project1.lesson15.connection.ConnectionManagerJdbc;
import project1.lesson15.dao.CatalogDao;
import project1.lesson15.dao.CatalogDaoJdbc;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginServlet
 *
 * @author "Andrei Prokofiev"
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ClientServes clientServes;
    private ConnectionManager connectionManager;

    @Inject
    private CatalogDao catalogDao;

    @Override
    public void init() throws ServletException {
        this.connectionManager = new ConnectionManagerJdbc();
        this.catalogDao = new CatalogDaoJdbc(connectionManager);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // вытаскиваем из запроса имя пользователя и его пароль
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        // если пользователь есть в системе
        if (catalogDao.isExist(name, password)) {

            // создаем для него сессию
            HttpSession session = req.getSession();

            // кладем в атрибуты сессии атрибут user с именем пользователя
            session.setAttribute("user", name);
            session.setMaxInactiveInterval(-1);

            req.getServletContext().getRequestDispatcher("/catalog").forward(req, resp);
        } else {
//            resp.sendRedirect(req.getContextPath() + "/login");
            doGet(req, resp);
        }

    }
}