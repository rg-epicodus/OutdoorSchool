package dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oSchoolDaoTest {
    private Connection conn;
    private Sql2oSchoolDao schoolDao;
    private Sql2oCourseDao courseDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:epicodus;INIT=RUNSCRIPT from 'classpath:db/schoolData.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        courseDao = new Sql2oCourseDao(sql2o);
        schoolDao = new Sql2oSchoolDao(sql2o);
        conn = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //test add

    //test findById

    //test deleteById

    //test deleteAllSchoolsRemovesAllCoursesAtThatSchool

    //helpers

}