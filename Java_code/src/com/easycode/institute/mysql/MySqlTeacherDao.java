package com.easycode.institute.mysql;

import com.easycode.institute.dao.TeacherDao;
import com.easycode.institute.domainobject.Teacher;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andrey on 01.03.2017.
 */
public class MySqlTeacherDao implements TeacherDao {

    private final Connection connection;

    public MySqlTeacherDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Teacher create() {
        return null;
    }

    @Override
    public Teacher read(int key) {
        return null;
    }

    @Override
    public void update(Teacher teacher) {

    }

    @Override
    public void delete(Teacher teacher) {

    }

    @Override
    public List<Teacher> getAll() throws SQLException {
        return null;
    }
}
