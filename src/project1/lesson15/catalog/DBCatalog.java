package src.project1.lesson15.catalog;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCatalog {

    private DBCatalog() {
    }

    public static void renewDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();
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
                    + ";");
//                    + "DROP FUNCTION IF EXISTS multiply(integer);"
//                    + "\n"
//                    + "CREATE OR REPLACE FUNCTION multiply(a INT) RETURNS INT AS $$\n"
//                    + "BEGIN\n"
//                    + "    RETURN a * 2;\n"
//                    + "END\n"
//                    + "$$ LANGUAGE 'plpgsql';");



        }
    }
}
