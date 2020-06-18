package project1.lesson15.connection;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * ConnectionManagerJdbc
 * Класс ответчает за подключение к базе данных.
 *
 * @author "Andrei Prokofiev"
 */

public class ConnectionManagerJdbc implements ConnectionManager {

    public static final ConnectionManager INSTANCE = new ConnectionManagerJdbc();
    private static final Logger LOGGER = LogManager.getLogger(ConnectionManagerJdbc.class);

    private ConnectionManagerJdbc() {
    }

    public static ConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() throws IOException {

        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/customers";

        try {
            connection = DriverManager.getConnection(
                    url,
                    "root",
                    "admin1982");
            LOGGER.debug(url);
//            LOGGER.throwing(Level.ERROR, new Throwable("TEST"));


        } catch (SQLException e) {
            LOGGER.throwing(Level.ERROR, e);
        }
        return connection;
    }
}
