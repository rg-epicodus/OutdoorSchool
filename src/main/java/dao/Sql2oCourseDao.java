package dao;

import org.sql2o.Sql2o;

public class Sql2oCourseDao implements CourseDao {
    private final Sql2o sql2o;

    public Sql2oCourseDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
