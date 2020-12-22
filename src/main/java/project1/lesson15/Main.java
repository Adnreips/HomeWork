package project1.lesson15;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.lesson15.client.Client;
import project1.lesson15.connection.ConnectionManager;
import project1.lesson15.connection.ConnectionManagerJdbc;
import project1.lesson15.dao.CatalogDao;
import project1.lesson15.dao.CatalogDaoJdbc;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

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
 * Добавлено модульное тестирование классов и методов программы.
 *
 * @author "Andrei Prokofiev"
 */

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManagerJdbc();
        CatalogDaoJdbc catalogDao = new CatalogDaoJdbc(connectionManager);
        catalogDao.creatTableClients();
        catalogDao.createTable();
        Client client = new Client(1, "Anton", "1", "1994-02-02");
        catalogDao.addTableClients(client);

    }
//    URL url = this.getClass().getClassLoader().getResource("persons.json");
//        if (url != null) {
//        List<Person> people = null;
//        try {
//            File jsonFile = new File(url.toURI());
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            people = objectMapper.readValue(jsonFile, new TypeReference<List<Person>>() {
//            });
//            personRepository.saveAll(people);
//            logger.info("All records saved.");
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//    } else {
//        logger.warn("url in null");
//    }




    public void method1(CatalogDao catalogDao) {
//        Catalog tovar = new Catalog(null, "Helicopter",
//                2500, "USA");
////        LOGGER.info(tovar);
//
//        long id = catalogDao.addCatalog(tovar);
//        tovar = catalogDao.getCatalogById(id);
//
//        tovar.setPrice(1500);
//        catalogDao.updateCatalogById(tovar);
//        tovar = catalogDao.getCatalogById(id);
//        LOGGER.info(tovar);
//
//        ClientServes clientServes = new ClientServes();
//        Client client1 = new Client("Anton", LocalDate.of(1982,01,28));
//        Client client2 = new Client("Anton", LocalDate.of(1983,01,28));
//        Client client3 = new Client("Anton", LocalDate.of(1985,01,28));
//        Client client4 = new Client("Anton", LocalDate.of(1984,01,28));
//        Client client5 = new Client(null, LocalDate.of(1982,01,28));
//
//        clientServes.doPayment();
//
//        clientServes.regClient(client1);
//        clientServes.regClient(client2);
//        try{
//            clientServes.logClient(client3);
//        }catch (RuntimeException e){
//            LOGGER.throwing(Level.WARN, e);
//        }
//
//        System.out.println("+++++++++++++++++++");
//
//        System.out.println(clientServes.getLogClients());
//
//
//        System.out.println("++++++++++++++++++");
//
//        try{
//        clientServes.regClient(client5);
//        } catch (RuntimeException e){
//            LOGGER.throwing(Level.WARN, e);
//        }
//
//        LOGGER.info(clientServes.getRegClients());


    }
}
