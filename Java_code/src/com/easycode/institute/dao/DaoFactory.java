package com.easycode.institute.dao;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;

/**
 * Created by Andrey on 01.03.2017.
 */
public interface DaoFactory {

    public Connection getConnection()throws SQLException;
    public TeacherDao getTeacherDao(Connection connection);

}
