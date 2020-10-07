package lk.nnj.mdss.fx.db;

import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    public static Connection getConnection() {
        if (connection==null){
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://mysql-11308-0.cloudclusters.net:11308/testdb",
                        "onetuser"
                        ,"1234"
                );
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Can not connect to the internet. Please check your internet connection.");
            }
        }
        return connection;
    }
}
