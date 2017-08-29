package dao;

import models.Course;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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
}
