/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class koneksi {

    private static Connection mysqlconfig;

    public static Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/mbaknis";
            String username = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            System.err.println("koneksi gagal!" + e.getMessage());
        }
        return mysqlconfig;
    }
}
