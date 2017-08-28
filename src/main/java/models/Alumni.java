package models;

public class Alumni extends Student{
    private int id;
    private int studentId;
    private String favoriteCourse;

    // constructors

    public Alumni(int courseId, String name, int age, boolean enrolled, int studentId, String favoriteCourse) {
        super(courseId, name, age, enrolled);
        this.studentId = studentId;
        this.favoriteCourse = favoriteCourse;
    }

    // getters and setters

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFavoriteCourse() {
        return favoriteCourse;
    }

    public void setFavoriteCourse(String favoriteCourse) {
        this.favoriteCourse = favoriteCourse;
    }

    // equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Alumni alumni = (Alumni) o;

        if (id != alumni.id) return false;
        if (studentId != alumni.studentId) return false;
        return favoriteCourse.equals(alumni.favoriteCourse);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + studentId;
        result = 31 * result + favoriteCourse.hashCode();
        return result;
    }
}
