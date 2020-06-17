package project1.lesson15.actors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * Client
 *
 * @author "Andrei Prokofiev"
 */
public class Client {
    Integer clientID;
    String nameClient;
    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    Marker marker = MarkerManager.getMarker("consoleonly").setParents();


    public Client(Integer clientID, String name) {
        this.clientID = clientID;
        this.nameClient = name;
    }
    public void registration(){}

    public void login(){}

    public void doPayment(){
        LOGGER.warn(marker,"doPayment");
    }

}
