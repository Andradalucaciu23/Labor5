package com.uni;

import UI.Konsole;
import model.Course;
import model.Student;
import model.Teacher;
import repository.RegistrationSystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class Main {
/*
    public static void main(String[] args) throws IOException {
	// write your code here
        Student s1 = new Student("Andrada", "Lucaciu", 1);
        Student s2 = new Student("Maria ", "Kriszte", 2);

        Teacher t1 = new Teacher("Lucian", "Popescu" , 1);
        Teacher t2 = new Teacher("Marinescu", "Andrei" , 2);

        Course c1 = new Course("MAP", 1, 1, 30, 4);
        Course c2 = new Course("BD", 2, 2, 50, 5);

        RegistrationSystem registrationSystem = new RegistrationSystem();
        registrationSystem.getStudentRepository().save(s1);
        registrationSystem.getStudentRepository().save(s2);

        registrationSystem.getTeacherRepository().save(t1);
        registrationSystem.getTeacherRepository().save(t2);

        registrationSystem.getCourseRepository().save(c1);
        registrationSystem.getCourseRepository().save(c2);

        System.out.println("Students List");
        for (Student student:registrationSystem.getAllStudents()) {
            System.out.println(student);
        }

        System.out.println("Teacher List");
        for (Teacher teacher:registrationSystem.getAllTeacher()) {
            System.out.println(teacher);
        }
        System.out.println("Courses List");
        for (Course course:registrationSystem.getAllCourses()) {
            System.out.println(course);
        }

        registrationSystem.register(c1, s1);
        registrationSystem.register(c1.getCourseID(), s2.getStudentID());
        registrationSystem.register(c2, s1);
        registrationSystem.register(c2.getCourseID(), s2.getStudentID());

        System.out.println("\n");
        System.out.println("Students List");
        for (Student student:registrationSystem.getAllStudents()) {
            System.out.println(student);
        }

        System.out.println("Teacher List");
        for (Teacher teacher:registrationSystem.getAllTeacher()) {
            System.out.println(teacher);
        }
        System.out.println("Courses List");
        for (Course course:registrationSystem.getAllCourses()) {
            System.out.println(course);
        }

        registrationSystem.unregister(c2.getCourseID(), s2.getStudentID());

        System.out.println("\n");
        System.out.println("Students enrolled for a course");
        System.out.println(registrationSystem.retireveStudentsEnrolledForACourse(c1.getCourseID()));
        System.out.println(registrationSystem.retireveStudentsEnrolledForACourse(c2.getCourseID()));

        System.out.println("Free Places");
        for (Map.Entry map: registrationSystem.retrieveCoursesWithFreePlaces().entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        registrationSystem.changeCreditFromACourse(1, 10);
        System.out.println("Courses List");
        for (Course course:registrationSystem.getAllCourses()) {
            System.out.println(course);
        }

        System.out.println("Delete Course");
        registrationSystem.deleteCourseFromATeacher(1, 1);
        System.out.println("Courses List");
        for (Course course:registrationSystem.getAllCourses()) {
            System.out.println(course);
        }
    }
*/

    public static void main(String[] args) throws SQLException {
        Konsole konsole = new Konsole();
    }
    }
