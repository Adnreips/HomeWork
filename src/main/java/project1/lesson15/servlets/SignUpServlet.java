package project1.lesson15.servlets;

import project1.lesson15.client.Client;
import project1.lesson15.client.ClientServes;
import project1.lesson15.connection.ConnectionManager;
import project1.lesson15.connection.ConnectionManagerJdbc;
import project1.lesson15.dao.CatalogDao;
import project1.lesson15.dao.CatalogDaoJdbc;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * SignInServlet
 *
 * @author "Andrei Prokofiev"
 */

@WebServlet(urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {

    private ConnectionManager connectionManager;

    @Inject
    private CatalogDao catalogDao;

    @Override
    public void init() throws ServletException {
//        this.clientServes = new ClientServes();
        this.connectionManager = new ConnectionManagerJdbc();
        this.catalogDao = new CatalogDaoJdbc(connectionManager);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clients = catalogDao.getAllClietns();
        req.setAttribute("usersFromServer", clients);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/signup.jsp");
        dispatcher.forward(req, resp);    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // вытащили данные регистрации
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String birthDate = req.getParameter("birthDate");
        // создали пользователя и сохранили его в хранилище
        Client user = new Client(0,name, password, birthDate);
        catalogDao.addTableClients(user);

        doGet(req, resp);
    }
}
