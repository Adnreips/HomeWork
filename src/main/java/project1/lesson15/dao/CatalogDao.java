package project1.lesson15.dao;


import project1.lesson15.catalog.Catalog;

import java.sql.Connection;

/**
 * CatalogDao
 *
 * @author "Andrei Prokofiev"
 */
public interface CatalogDao {
    Long addCatalog(Catalog catalog);

    Catalog getCatalogById(Long id);

    boolean updateCatalogById(Catalog catalog);

    boolean deleteCatalogById(Long id);
    void renewDatabase();

    ;

}
