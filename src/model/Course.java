package model;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private long courseID;
    private long teacherID;
    private int maxEnrollment;
    private List<Long> sttudentsEnrolled;
    private int credits;

    /**
     * wir erstellen ein neues Obj von Typ "Course"
     */

    public Course(String name, long courseID, long teacherID, int maxEnrollment,  int credits) {
        this.name = name;
        this.courseID = courseID;
        this.teacherID = teacherID;
        this.maxEnrollment = maxEnrollment;
        this.sttudentsEnrolled = new ArrayList<>();
        this.credits = credits;
    }

    public Course(String name, long courseID, long teacherID, int maxEnrollment, List<Long> sttudentsEnrolled, int credits) {
        this.name = name;
        this.courseID = courseID;
        this.teacherID = teacherID;
        this.maxEnrollment = maxEnrollment;
        this.sttudentsEnrolled = sttudentsEnrolled;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseID=" + courseID +
                ", teacherID=" + teacherID +
                ", maxEnrollment=" + maxEnrollment +
                ", sttudentsEnrolled=" + sttudentsEnrolled +
                ", credits=" + credits +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    public long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(long teacherID) {
        this.teacherID = teacherID;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public List<Long> getSttudentsEnrolled() {
        return sttudentsEnrolled;
    }

    public void setSttudentsEnrolled(List<Long> sttudentsEnrolled) {
        this.sttudentsEnrolled = sttudentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
