package dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oAlumniDaoTest {
    private Connection conn;
    private Sql2oAlumniDao alumniDao;
    private Sql2oStudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:epicodus;INIT=RUNSCRIPT from 'classpath:db/schoolData.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        alumniDao = new Sql2oAlumniDao(sql2o);
        studentDao = new Sql2oStudentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

}