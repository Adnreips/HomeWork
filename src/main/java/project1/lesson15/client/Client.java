package project1.lesson15.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Client
 *
 * @author "Andrei Prokofiev"
 */
public class Client {
    public String name;
    public LocalDate dateOfBirth;

    private static final Logger LOGGER = LogManager.getLogger(Client.class);
    private static Marker marker = MarkerManager.getMarker("consoleonly").setParents();

    public Client( String name, LocalDate clientID) {
        this.dateOfBirth = clientID;
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doPayment(){
        LOGGER.warn(marker,"doPayment");
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return dateOfBirth.equals(client.dateOfBirth) &&
                name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth, name);
    }
}
