package src.project1.lesson15.catalog;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBbuilder {
    static Logger logger = Logger.getLogger(DBbuilder.class.getName());

    private DBbuilder() {
    }

    public static void renewDatabase(Connection connection) {
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
                    + "\n"

                    + ";");
//                    + "DROP FUNCTION IF EXISTS multiply(integer);"
//                    + "\n"
//                    + "CREATE OR REPLACE FUNCTION multiply(a INT) RETURNS INT AS $$\n"
//                    + "BEGIN\n"
//                    + "    RETURN a * 2;\n"
//                    + "END\n"
//                    + "$$ LANGUAGE 'plpgsql';");


        } catch (SQLException e){
            logger.log(Level.WARNING, "Trouble renewDatabase", e);

        }
    }
}
