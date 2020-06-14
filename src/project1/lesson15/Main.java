package src.project1.lesson15;

import src.project1.lesson15.catalog.Catalog;
import src.project1.lesson15.dao.CatalogDaoJdbc;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
//        Integer[] localArgs = new Integer[]{1, 2, 3};
//        try (Connection connection = DriverManager.getConnection(
//                "jdbc:postgresql://localhost:5432/customers",
//                "root",
//                "admin1982")) {
//
//            DBbuilder.renewDatabase(connection);
//            try (Statement statement = connection.createStatement();
//                 ResultSet resultSet = statement.executeQuery("SELECT * FROM catalog")) {
//                while (resultSet.next()) {
//                    System.out.print("productId=" + resultSet.getInt("productId"));
//                    System.out.print("; nameProduct=" + resultSet.getString("nameProduct"));
//                    System.out.print("; price=" + resultSet.getInt("price"));
//                    System.out.println("; prodСountry=" + resultSet.getString("prodСountry"));
//                }
//            }
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    "SELECT * FROM catalog WHERE nameProduct = ? and price < ?")) {
//                preparedStatement.setString(1, "P1");
//                preparedStatement.setFloat(2, 1000);
//
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    while (resultSet.next()) {
//                        System.out.print("productId=" + resultSet.getInt("productId"));
//                        System.out.print("; nameProduct=" + resultSet.getString("nameProduct"));
//                        System.out.print("; price=" + resultSet.getInt("price"));
//                        System.out.println("; prodСountry=" + resultSet.getString(
//                                "prodСountry"));
//                    }
//                }
//            }
//
//            try (PreparedStatement preparedStatement = connection.prepareStatement(
//                    "update catalog set price=5000 where productId = ?")) {
//                for (Integer arg : localArgs) {
//                    preparedStatement.setInt(1, arg);
//                    preparedStatement.addBatch();
//                }
//                preparedStatement.executeBatch();
//            }
//            //Предусмотреть использование savepoint при выполнении логики из нескольких запросов.
//            try (Statement statement = connection.createStatement()) {
//                connection.setAutoCommit(false);
//                Savepoint savepoint = connection.setSavepoint();
//
//                for (int i = 0; i < 4; i++) {
//                    statement.executeUpdate(
//                            "INSERT INTO catalog (nameProduct, price, prodСountry)\n"
//                                    + "VALUES\n"
//                                    + "   ('G" + i + "', " + i*100 + ", 'Russia');"
//                    );
//                }
//                for (int i = 4; i < 8; i++) {
//                    statement.executeUpdate(
//                            "INSERT INTO catalog (nameProduct, price, prodСountry)\n"
//                                    + "VALUES\n"
//                                    + "   ('G" + i + "', " + i + ", 'SAMSUNG');"
//                    );
//                }
//                connection.rollback(savepoint);
//                connection.commit();
//
//            } catch (SQLException e) {
//                connection.rollback();
//                e.printStackTrace();
//            }
//        }
//
        System.setProperty("java.util.logging.config.file", "D:\\HomeWorkNew\\src\\project1\\logging.properties");

        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fileHandler = new FileHandler();
        logger.addHandler(fileHandler);

//        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));

//        System.out.println(System.getProperty("java.util.logging.config.file"));

        CatalogDaoJdbc catalogDao = new CatalogDaoJdbc();

        Catalog tovar = new Catalog(null, "Helicopter",
                3000, "USA");
        logger.config(tovar.toString());

        long productid = catalogDao.addCatalog(tovar);
        tovar = catalogDao.getCatalogById(productid);

        tovar.setPrice(2500);
        catalogDao.updateCatalogById(tovar);

        tovar = catalogDao.getCatalogById(productid);


//        logger.setUseParentHandlers(false);

        logger.config(tovar.toString());

    }
}
