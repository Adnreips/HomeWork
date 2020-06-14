package project1.lesson15.connection;

import java.io.IOException;
import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection() throws IOException;
}
