package project1.lesson15.client;

import org.apache.logging.log4j.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/**
 * ClientServes
 * В данном классе реализуется функционал действий клиента в
 * онлайн магазине.
 *
 * @author "Andrei Prokofiev"
 */
public class ClientServes {
    private static final Logger LOGGER = LogManager.getLogger(ClientServes.class);
    private static Marker marker = MarkerManager.getMarker("consoleonly").setParents();
    public static List<Client> regClients;
    private static List<Client> logClients = new ArrayList<>();
    private static ClientServes clientServes;

    static {
        clientServes = new ClientServes();
    }

    public ClientServes() {
        this.regClients = new ArrayList<>();
        Client user = new Client(1,"Andrei", "1", "1994-02-02");
        Client user1 = new Client(1,"Andrei1", "1", "1994-02-02");
        Client user2 = new Client(1,"Andrei2", "1", "1994-02-02");
        regClients.add(user);
        regClients.add(user1);
        regClients.add(user2);
    }

    public List<Client> getRegClients() {
        return regClients;
    }

    public List<Client> getLogClients() {
        return logClients;
    }

    public boolean regClient(Client client) {
        boolean flag = false;
        if (isNull(client.name) || client.name.isBlank()) {
            RuntimeException runtimeException = new RuntimeException("Name could not be empty or null");
            LOGGER.throwing(Level.INFO, runtimeException);
            throw runtimeException;

        }
        if (isNull(client.birthDate)) {
            RuntimeException runtimeException = new RuntimeException("Date of birth could not be null");
            LOGGER.throwing(Level.INFO, runtimeException);
            throw runtimeException;
        }
        if (!regClients.contains(client)) {
            regClients.add(client);
            flag = true;
        } else {
            LOGGER.throwing(Level.INFO, new RuntimeException("Customer allready exist"));
        }
        return flag;
    }

    public boolean logClient(Client client) {

        boolean flag = false;
        if (regClients.contains(client) && !logClients.contains(client)) {
            logClients.add(client);
            flag = true;
        } else {
            if (!regClients.contains(client)) {
                RuntimeException runtimeException = new RuntimeException("Please register");
                LOGGER.throwing(Level.INFO, runtimeException);
                throw runtimeException;
            } else {
                RuntimeException runtimeException = new RuntimeException("Customer allready login");
                LOGGER.throwing(Level.INFO, runtimeException);
                throw runtimeException;
            }
        }
        return flag;
    }

    public void removeClient(Client client) {
        regClients = regClients.stream()
                .filter(o -> !(o.equals(client)))
                .collect(Collectors.toList());
    }

    public void doPayment() {
        LOGGER.warn(marker, "doPayment");
    }

    public boolean isExist(String name, String password) {
        for (Client user : regClients) {
            if (user.getName().equals(name) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

}


