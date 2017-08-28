package dao;

import org.sql2o.Sql2o;

public class Sql2oStudentDao implements StudentDao {
    private final Sql2o sql2o;

    public Sql2oStudentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
