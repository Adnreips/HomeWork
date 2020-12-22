package project1.example.dao;

import project1.example.ConnectionManagerEx;
import project1.example.ConnectionManagerExImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MobileDaoJdbcImpl
 *
 * @author "Andrei Prokofiev"
 */
public class MobileDaoJdbcImpl implements MobileDao {
    public static final ConnectionManagerEx con = ConnectionManagerExImpl.getInstance();


    @Override
    public Long selectMobile() {
        try (Connection connection = con.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into mobile values (default, ?, ?, ?)")) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                System.out.println(result.getLong(1) + " " + result.getString(2));
            }
    } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return null;
    }
}
