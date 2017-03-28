package com.easycode.institute.mysql;

import com.easycode.institute.dao.TeacherDao;
import com.easycode.institute.domainobject.Teacher;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Teacher read(int key) throws SQLException {
        String sql = "SELECT * FROM institute.teachers WHERE id = ?;";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, key);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (ResultSet rs = stm.executeQuery()) {
            rs.next();
            Teacher t = new Teacher();
            t.setId(rs.getInt("id"));
            t.setFirstName(rs.getNString("firstname"));
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stm.close();
        }
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
