package project1.lesson15.dao;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.lesson15.catalog.Catalog;
import project1.lesson15.connection.ConnectionManager;
import java.io.IOException;
import java.sql.*;


/**
 * CatalogDaoJdbc
 * Класс ответчает за изменения в  базе данных.
 *
 * @author "Andrei Prokofiev"
 */

public class CatalogDaoJdbc implements CatalogDao {
    private static final Logger LOGGER = LogManager.getLogger(CatalogDaoJdbc.class);
    private ConnectionManager connectionManager;
    public static final String INSERT_INTO_CATALOG = "INSERT INTO catalog values (DEFAULT, ?, ?, ?)";
    public static final String SELECT_FROM_CATALOG = "SELECT * FROM catalog WHERE productid = ?";
    public static final String UPDATE_CATALOG = "UPDATE catalog SET nameproduct=?, price=?, prodСountry=? WHERE productid=?";
    public static final String DELETE_FROM_CATALOG = "DELETE FROM catalog WHERE productid=?";



    public CatalogDaoJdbc(ConnectionManager connectionManager)  {
       this.connectionManager = connectionManager;
    }

    @Override
    public Long addCatalog(Catalog catalog) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     INSERT_INTO_CATALOG, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, catalog.getNameProduct());
            preparedStatement.setInt(2, catalog.getPrice());
            preparedStatement.setString(3, catalog.getProdСountry());

            LOGGER.log(Level.DEBUG, "SQL add {}", INSERT_INTO_CATALOG);

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }

        } catch (SQLException e) {
            LOGGER.throwing(Level.ERROR, e);
        } catch (IOException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
        return 0L;
    }

    @Override
    public Catalog getCatalogById(Long productid) {
        String sqlRequest = "SELECT * FROM catalog WHERE productid = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CATALOG)) {
            preparedStatement.setLong(1, productid);
            LOGGER.log(Level.DEBUG, "SQL getCatalogById {}", SELECT_FROM_CATALOG);
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
            LOGGER.throwing(Level.ERROR, e);
        } catch (IOException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
        return null;
    }

    @Override
    public boolean updateCatalogById(Catalog catalog) {
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    UPDATE_CATALOG)) {


                connection.setAutoCommit(false);
                Savepoint savepoint = connection.setSavepoint();
                preparedStatement.setString(1, catalog.getNameProduct());
                preparedStatement.setInt(2, catalog.getPrice());
                preparedStatement.setString(3, catalog.getProdСountry());
                preparedStatement.setInt(4, catalog.getProductId());
                LOGGER.log(Level.DEBUG, "SQL updateCatalogById {}", UPDATE_CATALOG);
                preparedStatement.executeUpdate();
                connection.commit();
                return true;
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.throwing(Level.ERROR, e);

            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.throwing(Level.ERROR, e);
        } catch (IOException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
        return false;
    }

    @Override
    public boolean deleteCatalogById(Long productid) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CATALOG)) {
            preparedStatement.setLong(1, productid);
            LOGGER.log(Level.DEBUG, "SQL deleteCatalogById {}", DELETE_FROM_CATALOG);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.throwing(Level.ERROR, e);
            return false;
        } catch (IOException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
        return true;
    }

    @Override
    public void renewDatabase() {
        try (Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement();
        ) {
            statement.execute("-- Database: customers\n"
                    + "DROP TABLE IF EXISTS catalog ;"
                    + "\n"
                    + "CREATE TABLE catalog (\n"
                    + "    productId bigserial primary key,\n"
                    + "    nameProduct varchar(100) NOT NULL,\n"
                    + "    price integer NOT NULL,\n"
                    + "    prodСountry varchar(100) NOT NULL);"
                    + "\n"
                    + "INSERT INTO catalog (nameProduct, price, prodСountry)\n"
                    + "VALUES\n"
                    + "   ('P1', 100, 'China'),\n"
                    + "   ('EDGE', 1150, 'China'),\n"
                    + "   ('FRY1', 1001, 'China'),\n"
                    + "   ('FRY1', 1002, 'China'),\n"
                    + "   ('OGO', 10000, 'China');"
                    + "\n"
                    + "DROP TABLE IF EXISTS clients ;"
                    + "\n"
                    + "CREATE TABLE clients (\n"
                    + "    clientId bigserial primary key,\n"
                    + "    name varchar(100) NOT NULL);"
                    + "\n"
                    + "INSERT INTO clients (name)\n"
                    + "VALUES\n"
                    + "('Andrey');"
                    + "\n"
                    + "DROP TABLE IF EXISTS orderNew ;"
                    + "\n"
                    + "CREATE TABLE orderNew (\n"
                    + "    clientId bigserial primary key,\n"
                    + "    orderId integer NOT NULL,\n"
                    + "    productId integer NOT NULL,\n"
                    + "    dateOrder integer NOT NULL);"
                    + "\n"
                    + "INSERT INTO orderNew (orderId, productId, dateOrder)\n"
                    + "VALUES\n"
                    + "   (100, 1, 20200608);"
                    + "DROP TABLE IF EXISTS APP_LOGS ;"
//                    + "\n"
                    + "CREATE TABLE APP_LOGS (\n"
                    + "    LOG_ID varchar(100),\n"
                    + "    ENTRY_DATE varchar(100),\n"
                    + "    LOGGER varchar(100),\n"
                    + "    LOG_LEVEL varchar(100),\n"
                    + "    MESSAGE varchar(100),\n"
                    + "    EXCEPTION varchar(100));"
                    + "\n"
                    + ";");
            LOGGER.debug("SQL after creat table");

        } catch (SQLException | IOException e) {
            LOGGER.throwing(Level.ERROR, e);

        }

    }
}
