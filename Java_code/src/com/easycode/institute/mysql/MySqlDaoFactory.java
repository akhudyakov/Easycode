package com.easycode.institute.mysql;

import com.easycode.institute.dao.DaoFactory;
import com.easycode.institute.dao.TeacherDao;
import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Andrey on 01.03.2017.
 */
public class MySqlDaoFactory implements DaoFactory {

    private String username = "root";//Логин пользователя
    private String password = "mysql";
    private String url = "jdbc:mysql://localhost:3306/institute";
    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public MySqlDaoFactory() {
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка: Драйвер " + COM_MYSQL_JDBC_DRIVER + " не найден");
            System.exit(0);
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        try {
            java.sql.Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("The connection is established");
            return (Connection) con;
        } catch (SQLException e) {
            System.out.println("Error working with database " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TeacherDao getTeacherDao(Connection connection) {
        return new MySqlTeacherDao(connection, connection1);
    }
}

