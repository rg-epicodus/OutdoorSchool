package dao;

import models.Course;

import java.util.List;

public interface CourseDao {
    //create
    void add(Course course);
//    void addCourseToSchool(String location, int courseId);

    //read
//    List<Course> getAll();
//    List<Course> getAllCoursesByLocation(String location);
    Course findById(int courseId);

    //update
//    void updateCost(int newCost, int courseId);

    //delete
//    void deleteById(int courseId);
}
