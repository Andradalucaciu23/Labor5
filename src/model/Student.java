package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private long studentID;
    private int totalCredits;
    private List<Long> enrolledCourses;

    /**
     * wir erstellen ein neues Obk von Typ "Student"
     */

    public Student(Person person, long studentID) {
        super(person.getPersonID(), person.getVorname(), person.getNachname());
        this.studentID = studentID;
        this.totalCredits = 0;
        this.enrolledCourses = new ArrayList<>();
    }

    public Student(Person person, long studentID, int totalCredits, List<Long> enrolledCourses) {
        super(person.getPersonID(), person.getVorname(), person.getNachname());
        this.studentID = studentID;
        this.totalCredits = totalCredits;
        this.enrolledCourses = enrolledCourses;
    }


    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Long> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Long> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public void setVorname(String vorname) {
        super.setVorname(vorname);
    }

    @Override
    public void setNachname(String nachname) {
        super.setNachname(nachname);
    }

    @Override
    public String getVorname() {
        return super.getVorname();
    }

    @Override
    public String getNachname() {
        return super.getNachname();
    }
}
