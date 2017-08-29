package dao;

import models.Course;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oCourseDao implements CourseDao {
    private final Sql2o sql2o;

    public Sql2oCourseDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Course newCourse) {
        String sql = "INSERT INTO course (name, description, cost)"
                + "VALUES (:name, :description, :cost)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(newCourse)
                    .executeUpdate()
                    .getKey();
            newCourse.setCourseId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Course findById(int courseId) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM course WHERE courseId = :courseId")
                    .addParameter("courseId", courseId)
                    .executeAndFetchFirst(Course.class);
        }
    }

    @Override
    public void addCourseToSchool(String location, int courseId) {
        String sql = "INSERT INTO school_course (location, courseId) VALUES (:location, :courseId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("location", location)
                    .addParameter("courseId", courseId)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Course> getAllCoursesByLocation(String location) {
        List<Course> allCoursesAtLocation = new ArrayList<>();
        String sql = "SELECT courseId FROM school_course WHERE location = :location";
        try (Connection con = sql2o.open()) {
            List<Integer> courseIds = con.createQuery(sql)
                    .addParameter("location", location)
                    .executeAndFetch(Integer.class);
            for (Integer courseId: courseIds) {
                allCoursesAtLocation.add(
                        con.createQuery("SELECT * FROM course WHERE courseId = :courseId")
                                .addParameter("courseId", courseId)
                                .executeAndFetchFirst(Course.class));
            }
            return allCoursesAtLocation;
        }
    }
}
