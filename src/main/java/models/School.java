package models;

public class School {
    private int id;
    private String location;

    // constructors

    public School(String location) {
        this.location = location;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        if (id != school.id) return false;
        return location.equals(school.location);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + location.hashCode();
        return result;
    }
}
