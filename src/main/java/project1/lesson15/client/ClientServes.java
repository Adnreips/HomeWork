package project1.lesson15.client;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/**
 * ClientServes
 *
 * @author "Andrei Prokofiev"
 */
public class ClientServes {
    private static final Logger LOGGER = LogManager.getLogger(ClientServes.class);
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

    public List<Client> regClient(Client client) {
        if (isNull(client.name) || client.name.isBlank()) {
            LOGGER.throwing(Level.INFO, new RuntimeException("Name could not be empty or null"));
            return regClients;
        }
        if (isNull(client.dateOfBirth)) {
            LOGGER.throwing(Level.INFO, new RuntimeException("Date of birth could not be null"));
            return regClients;
        }
        if (!regClients.contains(client)) {
            regClients.add(client);
        } else {
            LOGGER.throwing(Level.INFO, new RuntimeException("Customer allready exist"));
        }
        return regClients;
    }

    public List<Client> logClient(Client client) {
        if (regClients.contains(client) && !logClients.contains(client)) {
            logClients.add(client);
        } else {
            if (!regClients.contains(client)) {
                LOGGER.throwing(Level.INFO, new RuntimeException("Please register"));
            } else {
                LOGGER.throwing(Level.INFO, new RuntimeException("Customer allready login"));
            }
        }
        return logClients;
    }

    public void removeClient(Client client) {
        regClients = regClients.stream()
                .filter(o -> !(o.equals(client)))
                .collect(Collectors.toList());
    }


}


