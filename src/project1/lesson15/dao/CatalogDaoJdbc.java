package src.project1.lesson15.dao;

import src.project1.lesson15.catalog.Catalog;
import src.project1.lesson15.catalog.DBbuilder;
import src.project1.lesson15.connection.ConnectionManager;
import src.project1.lesson15.connection.ConnectionManagerJdbc;

import java.io.IOException;
import java.sql.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogDaoJdbc implements CatalogDao {
    private static final ConnectionManager connectionManager =
            ConnectionManagerJdbc.getInstance();
    Logger logger = Logger.getLogger(CatalogDaoJdbc.class.getName());

    public CatalogDaoJdbc() throws SQLException, IOException {
        DBbuilder.renewDatabase(connectionManager.getConnection());
    }

    @Override
    public Long addCatalog(Catalog catalog) {

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO catalog values (DEFAULT, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, catalog.getNameProduct());
            preparedStatement.setInt(2, catalog.getPrice());
            preparedStatement.setString(3, catalog.getProdСountry());
            preparedStatement.executeUpdate();

            FileHandler fileHandler = new FileHandler();
            logger.addHandler(fileHandler);
            logger.log(Level.WARNING,"Проверка");



            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }

        } catch (SQLException e) {
            logger.log(Level.WARNING, "Trouble addCatalog", e);
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Catalog getCatalogById(Long productid) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM catalog WHERE productid = ?")) {
            preparedStatement.setLong(1, productid);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Catalog(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(4));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Trouble getCatalogById", e);
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateCatalogById(Catalog catalog) {
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE catalog SET nameproduct=?, price=?, prodСountry=? " +
                            "WHERE productid=?")) {

                connection.setAutoCommit(false);
                Savepoint savepoint = connection.setSavepoint();
                preparedStatement.setString(1, catalog.getNameProduct());
                preparedStatement.setInt(2, catalog.getPrice());
                preparedStatement.setString(3, catalog.getProdСountry());
                preparedStatement.setInt(4, catalog.getProductId());
                preparedStatement.executeUpdate();
                connection.commit();
                return true;
            } catch (SQLException e) {
                connection.rollback();
                logger.log(Level.WARNING, "Trouble updateCatalogById", e);
//                e.printStackTrace();

            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCatalogById(Long productid) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM catalog WHERE productid=?")) {
            preparedStatement.setLong(1, productid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Trouble deleteCatalogById", e);
            //            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
