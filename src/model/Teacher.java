package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private long teacherID;
    private List<Long> courses;

    /**
     * wir erstellen ein neuses Obj von Typ "Teacher"
     */

    public Teacher(Person person, long lehrerID) {
        super(person.getPersonID(), person.getVorname(), person.getNachname());
        this.teacherID = lehrerID;
        this.courses = new ArrayList<>();
    }

    public Teacher(Person person, long lehrerID, List<Long> vorlesungen) {
        super(person.getPersonID(), person.getVorname(), person.getNachname());
        this.teacherID = lehrerID;
        this.courses = vorlesungen;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", courses=" + courses +
                '}';
    }

    public long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(long teacherID) {
        this.teacherID = teacherID;
    }

    public List<Long> getCourses() {
        return courses;
    }

    public void setCourses(List<Long> courses) {
        this.courses = courses;
    }

    @Override
    public String getVorname() {
        return super.getVorname();
    }

    @Override
    public String getNachname() {
        return super.getNachname();
    }

    @Override
    public void setVorname(String vorname) {
        super.setVorname(vorname);
    }

    @Override
    public void setNachname(String nachname) {
        super.setNachname(nachname);
    }
}
