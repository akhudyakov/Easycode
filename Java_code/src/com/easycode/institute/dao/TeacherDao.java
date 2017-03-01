package com.easycode.institute.dao;

import com.easycode.institute.domainobject.Teacher;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andrey on 01.03.2017.
 */
public interface TeacherDao {

    public Teacher create();

    public Teacher read(int key);

    public void update(Teacher teacher);

    public void delete(Teacher teacher);

    public List<Teacher> getAll() throws SQLException;
}

