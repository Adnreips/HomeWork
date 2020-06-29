package project1.lesson15.client;

import org.apache.logging.log4j.*;

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

    private static List<Client> regClients = new ArrayList<>();
    private static List<Client> logClients = new ArrayList<>();

    public ClientServes() {
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
        if (isNull(client.dateOfBirth)) {
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


}


