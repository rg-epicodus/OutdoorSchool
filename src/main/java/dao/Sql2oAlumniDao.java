package dao;

import org.sql2o.Sql2o;

public class Sql2oAlumniDao implements AlumniDao {
    private final Sql2o sql2o;

    public Sql2oAlumniDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
