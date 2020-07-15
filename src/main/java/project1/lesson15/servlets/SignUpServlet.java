package project1.lesson15.servlets;

import project1.lesson15.client.Client;
import project1.lesson15.client.ClientServes;
import project1.lesson15.dao.CatalogDao;

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
    private ClientServes clientServes;


    @Inject
    private CatalogDao catalogDao;

    @Override
    public void init() throws ServletException {
        this.clientServes = new ClientServes();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clients = clientServes.regClients;
        req.setAttribute("usersFromServer", clients);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/signup.jsp");
        dispatcher.forward(req, resp);    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // вытащили данные регистрации
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        // создали пользователя и сохранили его в хранилище
        Client user = new Client(name, password, birthDate);
        clientServes.regClient(user);

        doGet(req, resp);
    }
}
