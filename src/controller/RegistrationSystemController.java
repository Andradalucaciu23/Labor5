package controller;

import exception.DeleteCourseFromTeacherException;
import exception.ExistException;
import exception.RegisterException;
import model.Person;
import model.Teacher;
import model.Student;
import model.Course;
import repository.RegistrationSystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class RegistrationSystemController{
    private final RegistrationSystem registrationSystem ;

    public RegistrationSystemController() throws SQLException {
        this.registrationSystem = new RegistrationSystem();
    }


    public void controller_register(long CourseID, long StudentID) throws RegisterException, IOException, SQLException {
        registrationSystem.register(CourseID, StudentID);
    }


    public void controller_unregister(long CourseID, long StudentID) throws RegisterException, SQLException {
        registrationSystem.unregister(CourseID, StudentID);
    }


    public List<Course> controller_getAllCourses() throws SQLException {
        return registrationSystem.getAllCourses();
    }


    public List<Student> controller_getAllStudents() throws SQLException {
        return registrationSystem.getAllStudents();
    }


    public List<Teacher> controller_getAllTeacher() throws SQLException {
        return registrationSystem.getAllTeachers();
    }

    public List<Person> controller_getAllPersons() throws SQLException {
        return registrationSystem.getAllPersons();
    }
    public HashMap<Integer, Long> controller_retrieveCoursesWithFreePlaces() throws SQLException {
        return registrationSystem.retrieveCoursesWithFreePlaces();
    }


    public List<Long> controller_retrieveStudentsEnrolledForACourse(long CourseID) throws ExistException, SQLException {
        return registrationSystem.retrieveStudentsEnrolledForACourse(CourseID);
    }


    public void controller_changeCreditFromACourse(long CourseID, int newCredit) throws RegisterException, ExistException, IOException, SQLException {
        registrationSystem.changeCreditFromACourse(CourseID, newCredit);
    }


    public void controller_deleteCoursesFromTeacher(long TeacherID, long CourseID) throws DeleteCourseFromTeacherException, RegisterException, SQLException {
        registrationSystem.deleteCourseFromLehrer(TeacherID,CourseID);
    }


    public List<Student> controller_sortListeStudents() throws SQLException {
        Collections.sort(registrationSystem.getAllStudents(), new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getVorname().compareTo(s2.getVorname());
            }
        });

        return registrationSystem.getAllStudents();
    }


    public List<Course> controller_sortListeCourses() throws SQLException {
        Collections.sort(registrationSystem.getAllCourses(), new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });

        return registrationSystem.getAllCourses();
    }


    public List<Student> controller_filterListeStudenten() throws SQLException {
        List<Student> studentList = this.controller_getAllStudents().stream()
                .filter(student -> student.getEnrolledCourses().size() >=2).collect(Collectors.toList());

        return studentList;
    }


    public List<Course> controller_filterListeCourses() throws SQLException {
        List<Course> courseslist = this.controller_getAllCourses().stream()
                .filter(course -> course.getMaxEnrollment() > 30).collect(Collectors.toList());

        return courseslist;
    }


    public void controller_addStudent(Long PersonID, Long StudentID) throws SQLException {
        if (registrationSystem.getPersonRepository().findOne(Math.toIntExact(PersonID)) != null) {
            registrationSystem.getStudentRepository()
                    .save(new Student(registrationSystem.getPersonRepository().findOne(Math.toIntExact(PersonID)), StudentID));
        }
    }


    public void controller_addTeacher(Long PersonID, Long TeacherID) throws SQLException {
        if (registrationSystem.getTeacherRepository().findOne(PersonID) != null){
            registrationSystem.getTeacherRepository()
                    .save(new Teacher(registrationSystem.getPersonRepository().findOne(Math.toIntExact(PersonID)), TeacherID));
        }

    }


    public void controller_addCourse(String Name, Long IdTeacher, Long IdCourse, int MaxEnrollment, int Credits) throws SQLException {
        registrationSystem.getCourseRepository().save(new Course(Name, IdTeacher, IdCourse, MaxEnrollment, Credits));
    }


    public void controller_addPerson(Long personID, String Vorname, String Nachname) throws SQLException {
        this.registrationSystem.getPersonRepository()
                .save(new Person(personID, Vorname, Nachname));
    }
}