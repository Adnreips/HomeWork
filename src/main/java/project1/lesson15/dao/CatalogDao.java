package project1.lesson15.dao;


import project1.lesson15.catalog.Catalog;
import project1.lesson15.client.Client;

import java.util.List;

/**
 * CatalogDao
 *
 * @author "Andrei Prokofiev"
 */
public interface CatalogDao {

    Catalog getCatalogById(Integer id);

    void createTable();

    List<Catalog> getAllCatalog();
//    boolean updateCatalogById(Catalog catalog);

    boolean deleteCatalogById(Integer id);

    void renewDatabase();

    Integer addCatalog(Catalog catalog);

    void creatTableClients();

    Integer addTableClients(Client client);

    Client getClientById(Integer id);

    List<Client> getAllClietns();

    boolean isExist(String name, String password);

}
