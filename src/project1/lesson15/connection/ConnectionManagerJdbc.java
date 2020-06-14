package src.project1.lesson15.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManagerJdbc implements ConnectionManager {

    public static final ConnectionManager INSTANCE = new ConnectionManagerJdbc();
    Logger logger = Logger.getLogger(Connection.class.getName());

    private ConnectionManagerJdbc() {
    }

    public static ConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() throws IOException {
        Connection connection = null;
        try {
//            FileHandler fileHandler = new FileHandler();
//            logger.addHandler(fileHandler);

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/customers",
                    "root",
                    "admin1982");
        } catch (SQLException e) {

            logger.log(Level.WARNING, "Trouble getConnection: ", e);
//            e.printStackTrace();
        }
        return connection;
    }
}
