package project1.lesson15.dao;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.lesson15.catalog.Catalog;
import project1.lesson15.client.Client;
import project1.lesson15.connection.ConnectionManager;
import project1.lesson15.connection.Myconnect;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * CatalogDaoJdbc
 * Класс ответчает за изменения в  базе данных.
 *
 * @author "Andrei Prokofiev"
 */

@EJB
public class CatalogDaoJdbc implements CatalogDao {
    private static final Logger LOGGER = LogManager.getLogger(CatalogDaoJdbc.class);

    public static final String UPDATE_CATALOG = "UPDATE catalog SET nameproduct=?, price=?, prodСountry=? WHERE id=?";
    public static final String DELETE_FROM_CATALOG = "DELETE FROM catalog WHERE id=?";
    public static final String INSERT_INTO_CATALOG = "INSERT INTO catalog values (DEFAULT, ?, ?, ?)";
    public static final String INSERT_INTO_CLIENTS = "INSERT INTO clients values (DEFAULT, ?, ?, ?)";
    public static final String SELECT_FROM_CATALOG = "SELECT * FROM catalog WHERE id = ?";
    public static final String SELECT_ALL_FROM_CATALOG = "SELECT * FROM catalog";
    public static final String SELECT_ALL_FROM_CLIENTS = "SELECT * FROM clients";

    public static final String CREATE_TABLE_CATALOG = "DROP TABLE IF EXISTS catalog ;"
            + "\n"
            + "CREATE TABLE catalog (\n"
            + "    id bigserial primary key,\n"
            + "    nameProduct varchar(100) NOT NULL,\n"
            + "    price integer NOT NULL,\n"
            + "    manufacturer varchar(100) NOT NULL);"
            + "\n"
            + "INSERT INTO catalog (nameProduct, price, manufacturer)\n"
            + "VALUES\n"
            + "   (' Рhone P1', 100, 'China'),\n"
            + "   (' Рhone EDGE', 1150, 'China'),\n"
            + "   (' Рhone FRY1', 1001, 'China'),\n"
            + "   (' Рhone OGO', 10000, 'China');"
            + "\n";

    public static final String CREATE_TABLE_CLIENTS = "DROP TABLE IF EXISTS clients ;"
            + "\n"
            + "CREATE TABLE clients (\n"
            + "    id bigserial primary key,\n"
            + "    name varchar(100),\n"
            + "    password varchar(100),\n"
            + "    birthDate date);"
            + "\n"
            + "INSERT INTO clients (name, password, birthDate)\n"
            + "VALUES\n"
            + "   ('Adnrei', '1', '1994-04-01'),\n"
            + "   ('Adnrei1', '1', '1994-04-01'),\n"
            + "   ('Adnrei3', '1', '1992-01-01');"
            + "\n";

    private final ConnectionManager connectionManager;

    @Inject
    public CatalogDaoJdbc(@Myconnect ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
        createTable();
        creatTableClients();
    }

    @Override
    public Integer addCatalog(Catalog catalog) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     INSERT_INTO_CATALOG, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, catalog.getNameProduct());
            preparedStatement.setInt(2, catalog.getPrice());
            preparedStatement.setString(3, catalog
                    .getManufacturer());

            LOGGER.log(Level.DEBUG, "SQL add {}", INSERT_INTO_CATALOG);

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }

        } catch (SQLException e) {
            LOGGER.throwing(Level.ERROR, e);
        } catch (IOException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
        return 0;
    }

    @Override
    public void creatTableClients() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_CLIENTS)) {
            preparedStatement.execute();
        } catch (SQLException | IOException e) {
            LOGGER.error("Some thing wrong in creatTableClients method", e);
        }

    }

    @Override
    public void createTable() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_CATALOG)) {
            preparedStatement.execute();
        } catch (SQLException | IOException e) {
            LOGGER.error("Some thing wrong in createTable method", e);
        }
    }

    @Override
    public Integer addTableClients(Client client) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     INSERT_INTO_CLIENTS, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getPassword());
            preparedStatement.setDate(3, Date.valueOf(client.getBirthDate()));

            LOGGER.log(Level.DEBUG, "SQL add {}", INSERT_INTO_CLIENTS);

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }

        } catch (SQLException e) {
            LOGGER.throwing(Level.ERROR, e);
        } catch (IOException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
        return 0;
    }

    @Override
    public Client getClientById(Integer id) {
        return null;
    }

    @Override
    public List<Client> getAllClietns() {
        List<Client> lstmb = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_CLIENTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                lstmb.add(new Client(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));
            }
            return lstmb;
        } catch (SQLException | IOException e) {
            LOGGER.error("Some thing wrong in getMobileById method", e);
        }
        return new ArrayList<>();

    }

    @Override
    public List<Catalog> getAllCatalog() {
        List<Catalog> lstmb = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_CATALOG);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                lstmb.add(new Catalog(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)));
            }
            return lstmb;
        } catch (SQLException | IOException e) {
            LOGGER.error("Some thing wrong in getMobileById method", e);
        }
        return new ArrayList<>();
    }

    @Override
    public Catalog getCatalogById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CATALOG)) {
            preparedStatement.setInt(1, id);
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

//    @Override
//    public boolean updateCatalogById(Catalog catalog) {
//        try (Connection connection = connectionManager.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    UPDATE_CATALOG)) {
//
//
//                connection.setAutoCommit(false);
//                Savepoint savepoint = connection.setSavepoint();
//                preparedStatement.setString(1, catalog.getNameProduct());
//                preparedStatement.setInt(2, catalog.getPrice());
//                preparedStatement.setString(3, catalog.getProdСountry());
//                preparedStatement.setInt(4, catalog.getId());
//                LOGGER.log(Level.DEBUG, "SQL updateCatalogById {}", UPDATE_CATALOG);
//                preparedStatement.executeUpdate();
//                connection.commit();
//                return true;
//            } catch (SQLException e) {
//                connection.rollback();
//                LOGGER.throwing(Level.ERROR, e);
//
//            }
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            LOGGER.throwing(Level.ERROR, e);
//        } catch (IOException e) {
//            LOGGER.throwing(Level.ERROR, e);
//        }
//        return false;
//    }

    @Override
    public boolean deleteCatalogById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CATALOG)) {
            preparedStatement.setInt(1, id);
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
                    + "    id integer NOT NULL,\n"
                    + "    dateOrder integer NOT NULL);"
                    + "\n"
                    + "INSERT INTO orderNew (orderId, id, dateOrder)\n"
                    + "VALUES\n"
                    + "   (100, 1, 20200608);"
                    + "DROP TABLE IF EXISTS APP_LOGS ;"
                    + "\n"
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
    public boolean isExist(String name, String password) {
        for (Client user : getAllClietns()) {
            if (user.getName().equals(name) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }



}
