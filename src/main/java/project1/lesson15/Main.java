package project1.lesson15;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.lesson15.actors.Client;
import project1.lesson15.actors.Seller;
import project1.lesson15.catalog.Catalog;
import project1.lesson15.dao.CatalogDaoJdbc;

import java.io.IOException;
import java.sql.SQLException;
/**
 * Main
 * В данной программе производится подключение к базе данных, создаются таблицы
 * и заносятся данные в них с помощью разных методов.
 * Также в данной программе меняем вывод информации предыдущей задачи на
 * логирование с использованием фреймворка log4j2.
 * Для отладки используется уровень логирования debug, эти сообщения будут
 * выводиться в консоль в случае, если уровень выводимых сообщений будет снижен до debug
 * или ниже (по умолчанию выводятся сообщения не ниже info).
 * Бизнес сообщения будуте выводиться в файл log.log из папки logs.
 * Сообщение безопасности будут выводится в файл log2.log из папки logs.
 * Системная информация будет выводиться в базу данных customers.
 *
 * @author "Andrei Prokofiev"
 */

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, IOException {
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

        Seller seller = new Seller(1, "Bob");
        seller.makeBill();

        Client client = new Client(1, "Anton");
        client.doPayment();


    }
}
