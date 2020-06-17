package project1.lesson15;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.lesson15.actors.Client;
import project1.lesson15.actors.Seller;
import project1.lesson15.catalog.Catalog;
import project1.lesson15.dao.CatalogDaoJdbc;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, IOException {
//        System.out.println(LOGGER.getName());
        CatalogDaoJdbc catalogDao = new CatalogDaoJdbc();

        Catalog tovar = new Catalog(null, "Helicopter",
                2500, "USA");
        LOGGER.info(tovar);

        long productid = catalogDao.addCatalog(tovar);
        tovar = catalogDao.getCatalogById(productid);

        tovar.setPrice(1500);
        catalogDao.updateCatalogById(tovar);

        tovar = catalogDao.getCatalogById(productid);
        LOGGER.info(tovar);
        LOGGER.throwing(Level.INFO,new Throwable("TEST"));

        Seller seller = new Seller(1, "Bob");
        seller.makeBill();

        Client client = new Client(1, "Anton");
        client.doPayment();


    }
}
