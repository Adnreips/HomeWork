package project1.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionManagerExImpl
 *
 * @author "Andrei Prokofiev"
 */
public class ConnectionManagerExImpl implements ConnectionManagerEx {
    public static final ConnectionManagerEx INSTANCE = new ConnectionManagerExImpl();

    private ConnectionManagerExImpl() {
    }

    public static ConnectionManagerEx getInstance() {
        return INSTANCE;
    }


    @Override
    public Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/customers", "root", "admin1982");
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
