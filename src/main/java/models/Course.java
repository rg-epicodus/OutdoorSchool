package models;

public class Course {
    private int courseId;
    private String name;
    private String description;
    private int cost;

    // constructors

    public Course(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    // getters and setters

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    // equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != course.courseId) return false;
        if (cost != course.cost) return false;
        if (!name.equals(course.name)) return false;
        return description != null ? description.equals(course.description) : course.description == null;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + cost;
        return result;
    }
}
