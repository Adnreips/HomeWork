package src.project1.lesson15;

import src.project1.lesson15.catalog.DBCatalog;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/customers",
                "root",
                "admin1982")) {

            DBCatalog.renewDatabase(connection);
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM catalog")) {
                while (resultSet.next()) {
                    System.out.print("id=" + resultSet.getInt("productId"));
                    System.out.print("; model=" + resultSet.getString("nameProduct"));
                    System.out.print("; price=" + resultSet.getInt("price"));
                    System.out.println("; manufacturer=" + resultSet.getString("prodСountry"));
                }
            }

        }
    }
}
