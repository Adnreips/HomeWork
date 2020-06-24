package project1.lesson15.seller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * Seller
 *
 * @author "Andrei Prokofiev"
 */
public class Seller {
    private Integer sellerId;
    private String nameSeller;
    private static final Logger LOGGER = LogManager.getLogger(Seller.class);
    Marker marker = MarkerManager.getMarker("consoleonly");

    public Seller(Integer sellerId, String nameSeller) {
        this.sellerId = sellerId;
        this.nameSeller = nameSeller;
    }

    public void makeBill() {
        LOGGER.warn(marker,"makeBill");




    }

    public boolean chackOut(){
       return true;
    }

    public Integer getOrder() {
        return 0;
    }

    public void send() {}
}
