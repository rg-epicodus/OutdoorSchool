import dao.Sql2oAlumniDao;
import dao.Sql2oCourseDao;
import dao.Sql2oSchoolDao;
import dao.Sql2oStudentDao;
import exception.ApiException;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        String connectionString = "jdbc:h2:~/API.db;INIT=RUNSCRIPT from 'classpath:db/schoolData.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oAlumniDao alumniDao = new Sql2oAlumniDao(sql2o);
        Sql2oCourseDao courseDao = new Sql2oCourseDao(sql2o);
        Sql2oSchoolDao schoolDao = new Sql2oSchoolDao(sql2o);
        Sql2oStudentDao studentDao = new Sql2oStudentDao(sql2o);
        Gson gson = new Gson();
        Connection conn;
        conn = sql2o.open();


        //exception
//        exception(ApiException.class, (exc, req, res) -> {
//            ApiException err = (ApiException) exc;
//            Map<String, Object> jsonMap = new HashMap<>();
//            jsonMap.put("status", err.getStatusCode());
//            jsonMap.put("errorMessage", err.getMessage());
//            res.type("application/json");
//            res.status(err.getStatusCode());
//            res.body(gson.toJson(jsonMap));
//        });

        // filters
//        after((req, res) ->{
//            res.type("application/json");
//        });
    }
}
