package project1.lesson15.dao;


import project1.lesson15.catalog.Catalog;

import java.sql.Connection;
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

//    boolean deleteCatalogById(Long id);
//    void renewDatabase();
//    Long addCatalog(Catalog catalog);


}
