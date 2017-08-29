package dao;
import models.Course;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.After;
import org.junit.Before;


import java.util.Arrays;

import static org.junit.Assert.*;

public class Sql2oCourseDaoTest {
    private Connection conn;
    private Sql2oCourseDao courseDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:epicodus;INIT=RUNSCRIPT from 'classpath:db/schoolData.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        courseDao = new Sql2oCourseDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    //test add
    @Test
    public void add() throws Exception {
        Course courses = newCourse();
        courseDao.add(course);
        assertEquals(course, courseDao.findById(course.getCourseId()));
    }
    //test addCourseToSchool
//    @Test
//    public void addCourseToSchool() throws Exception {
//        Course newCourse = newCourse();
//        courseDao.add(newCourse);
//        Course newAltCourse = newAltCourse();
//        courseDao.add(newAltCourse);
//        courseDao.addCourseToSchool("San Diego", newCourse.getCourseId());
//        courseDao.addCourseToSchool("Portland", newAltCourse.getCourseId());
//        assertEquals(Arrays.asList(newAltCourse), courseDao.getAllCoursesByLocation("Portland"));
//    }
    //test update
//    @Test
//    public void updateCost() throws Exception {
//        courseDao.add(newCourse());
//        courseDao.add(newAltCourse());
//        Course course = newCourse();
//        courseDao.add(course);
//        courseDao.updateCost(8400, course.getCourseId());
//        assertEquals(8400, courseDao.findById(course.getCourseId()).getCost());
//    }
    //test deleteById
//    @Test
//    public void trackFinished() throws Exception {
//        courseDao.add(newCourse());
//        courseDao.add(newAltCourse());
//        Course course = newCourse();
//        courseDao.add(course);
//        courseDao.deleteById(course.getCourseId());
//        assertEquals(2, courseDao.getAll().size() );
//    }
    //helpers
    public Course newCourse() {
        return new Course("Archery", "I learned how to shoot a bullseye", 2475);
    }

    public Course newAltCourse() {
        return new Course("Blacksmithing", "I made a sword", 1750);
    }
}