package project1.lesson15.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project1.lesson15.Main;


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
//            FileHandler fileHandler = new FileHandler();
//            logger.addHandler(fileHandler);

            connection = DriverManager.getConnection(
                    url,
                    "root",
                    "admin1982");
            LOGGER.debug(url);
//            LOGGER.throwing(Level.INFO, new Throwable("TEST"));


        } catch (SQLException e) {
            LOGGER.throwing(Level.INFO,e);
//            LOGGER.log(Level.WARNING, "Trouble getConnection: ", e);
//            e.printStackTrace();
        }
        return connection;
    }
}
