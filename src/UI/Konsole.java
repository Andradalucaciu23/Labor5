package UI;

import repository.RegistrationSystem;
import controller.RegistrationSystemController;
import exception.DeleteCourseFromTeacherException;
import exception.ExistException;
import exception.RegisterException;
import model.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;


/*
public class Konsole {
    private RegistrationSystemController registrationSystemController;

    //RegistrationSystemController registrationSystem = new RegistrationSystemController();
    /*
    CourseFileController courseController;
    String courseFileName;
    StudentFileController studentController;
    String studentFileName;
    TeacherFileController teacherController;
    String teacherFileName;

     */
/*
    public Konsole() throws SQLException {
        try {
            this.registrationSystemController = new RegistrationSystemController();
        } catch (SQLException e) {
            System.out.println("\n" + "Fehler beim Öffnen der Konsole");
        }
        System.out.println("Menu!   \nCase 1: Register " +
                "\nCase 2:  Alle Courses " +
                "\nCase 3:  Alle Teachers " +
                "\nCase 4:  Alle Students " +
                "\nCase 5:  Alle Courses mit freie Platze " +
                "\nCase 6:  Alle Students von einer Course " +
                "\nCase 7:  Change Credits " +
                "\nCase 8:  Studenten sortiere " +
                "\nCase 9:  Courses sortiere " +
                "\nCase 10: Studenten filtrieren " +
                "\nCase 11: Courses filtrieren " +
                "\nCase 12: Exit\n ");

        //fileNameUI();
        //ui_addElements();
/*
        Scanner com = new Scanner(System.in);
        int commInput;
        do {
            System.out.println("\nCommand: ");
            switch (commInput = com.nextInt()) {
                case 12:
                    System.out.println("Exit!");
                    break;
                case 1:
                    System.out.println("Register");
                    ui_register();
                    break;
                case 2:
                    System.out.println("Alle coureses");
                    ui_getAllCourses();
                    //getAllCoursesFromFileUI();
                    break;
                case 3:
                    System.out.println("Alle students");
                    //getAllStudentsUI();
                    ui_getAllStudents();
                    break;
                case 4:
                    System.out.println("Alle teachers");
                    //get();
                    //getllTeachersFromFileUI();
                    break;
                case 5:
                    System.out.println("Courses mit freie Plätze");
                    ui_retrieveCoursesWithFreePlaces();
                    break;
                case 6:
                    System.out.println("Alle Students von einer Course");
                    ui_retrieveStudentsEnrolledForACourse();
                    break;
                case 7:
                    System.out.println("Change Credits");
                    ui_changeCreditFromACourse();
                    break;
                case 8:
                    System.out.println("Sortiere Studenten");
                    ui_sortListeStudenten();
                    break;
                case 9:
                    System.out.println("sortiere Courses");
                    ui_sortListeCourses();
                    break;
                case 10:
                    System.out.println("Studenten filtiere");
                    ui_filterListeStudents();
                    break;
                case 11:
                    System.out.println("Courses filtriere");
                    ui_filterListeCourses();
                    break;

            }
        } while (commInput != 0);

    }
/*
    private void ui_register() {
        System.out.println("Register");
        Scanner idCourse = new Scanner(System.in);
        Scanner idStudent = new Scanner(System.in);
        long CourseID, StudentID;

        System.out.println("Course ID: ");
        CourseID = idCourse.nextLong();
        System.out.println("Student ID: ");
        StudentID = idStudent.nextLong();
        try {
            registrationSystemController.controller_register(CourseID, StudentID);
        } catch (RegisterException | IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/*
    private void ui_unregister() {
        System.out.println("Unregister");
        Scanner idCourse = new Scanner(System.in);
        Scanner idStudent = new Scanner(System.in);
        long CourseID, StudentID;

        System.out.println("Course ID: ");
        CourseID = idCourse.nextLong();
        System.out.println("Student ID: ");
        StudentID = idStudent.nextLong();
        try {
            registrationSystemController.controller_unregister(CourseID, StudentID);
        } catch (RegisterException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    private void ui_getAllCourses() {
        System.out.println("Liste der Courses");
        try {
            this.registrationSystemController.controller_getAllCourses()
                    .forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    /*
    private void ui_getAllCoursesFromFile() throws SQLException {
        for (Course course : registrationSystemController.controller_getAllCourses()) {
            try {
                registrationSystemController.controller_update(course);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Problem mit der Aktualisierung der Datei");
            }
        }



        try {
            for (Course course : registrationSystemController.controller_findAll()) {
                System.out.println(course);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Problem mit der 'Vorlesung'-Datei. ");
        }
    }
     */
/*
    private void ui_getAllStudents(){
        System.out.println("Liste der Studenten");
        try {
            this.registrationSystemController.controller_getAllStudents()
                    .forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    */

    /*
    private void ui_getAllStudentsFromFile() throws SQLException {
        System.out.println("Print Liste Studenten aus der Datei");
        for (Student student : registrationSystemController.controller_getAllStudents()) {
            try {
                studentController.controller_update(student);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Problem mit der Aktualisierung der Datei");
            }
        }

        try {
            for (Student student : studentController.controller_findAll()) {
                System.out.println(student);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Problem mit der 'Student'-Datei. ");
        }
    }

     */

    /*
    private void ui_getAllLehrerFromFile() {
        System.out.println("Print Liste Lehrer aus der Datei");
        for (Teacher teacher : registrationSystem.controller_getAllTeacher()) {
            try {
                teacherController.controller_update(teacher);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Problem mit der Aktualisierung der Datei");
            }
        }

        try {
            for (Teacher lehrer: teacherController.controller_findAll()) {
                System.out.println(lehrer);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Problem mit der 'Lehrer'-Datei. ");
        }

    }


     */
/*
    private void ui_retrieveCoursesWithFreePlaces(){
        System.out.println("Courses mit freie Plätze");
        try {
            for (Map.Entry map: registrationSystemController.controller_retrieveCoursesWithFreePlaces().entrySet()) {
                System.out.println(map.getKey() + " " + map.getValue());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ui_retrieveStudentsEnrolledForACourse(){
        System.out.println("Print Liste der Studenten von einer Course");
        Scanner idCourse = new Scanner(System.in);
        long CourseID;

        System.out.println("Course ID: ");
        CourseID = idCourse.nextLong();
        try {
            for (Long student:registrationSystemController.controller_retrieveStudentsEnrolledForACourse(CourseID)) {
                System.out.println(student);
            }
        } catch (ExistException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ui_changeCreditFromACourse(){
        System.out.println("Credit Anzahl ändern");
        Scanner idCourse = new Scanner(System.in);
        Scanner credits = new Scanner(System.in);
        long CourseID;
        int newCredit;

        System.out.println("Course ID: ");
        CourseID = idCourse.nextLong();
        System.out.println("New Credits: ");
        newCredit = credits.nextInt();
        try {
            registrationSystemController.controller_changeCreditFromACourse(CourseID, newCredit);
        } catch (RegisterException | ExistException | SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ui_deleteCourseFromLehrer(){
        System.out.println("Course löschen");
        Scanner idCourse = new Scanner(System.in);
        Scanner idTeacher = new Scanner(System.in);
        long CourseId, TeacherId;

        System.out.println("Course ID: ");
        CourseId = idCourse.nextLong();
        System.out.println("Teacher ID: ");
        TeacherId = idTeacher.nextLong();
        try {
            registrationSystemController.controller_deleteCoursesFromTeacher(TeacherId, CourseId);
        } catch (DeleteCourseFromTeacherException | RegisterException | SQLException e) {
            System.out.println(e.getMessage());
        }

        ui_getAllCourses();
    }

    private void ui_sortListeStudenten(){
        System.out.println("Sort Liste Students");
        try {
            this.registrationSystemController.controller_sortListeStudents()
                    .forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ui_sortListeCourses(){
        System.out.println("Sort Liste Courses");
        try {
            this.registrationSystemController.controller_sortListeCourses()
                    .forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ui_filterListeStudents(){
        System.out.println("Filter Liste Students");
        try {
            this.registrationSystemController.controller_filterListeStudenten()
                    .forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ui_filterListeCourses(){
        System.out.println("Filter Liste Courses");
        try {
            this.registrationSystemController.controller_filterListeCourses()
                    .forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void ui_addStudent(){
        System.out.println("Add Student");
        Scanner studentID = new Scanner(System.in);
        Scanner personID = new Scanner(System.in);
        long StudentID, PersonID;

        System.out.println("Person ID: ");
        PersonID = personID.nextLong();
        System.out.println("Student ID: ");
        StudentID = studentID.nextLong();

        try {
            registrationSystemController.controller_addStudent(PersonID, StudentID);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void ui_addTeacher(){
        System.out.println("Add Teacher");
        Scanner teacherID = new Scanner(System.in);
        Scanner personID = new Scanner(System.in);
        long LehrerID, PersonID;

        System.out.println("Person ID: ");
        PersonID = personID.nextLong();
        System.out.println("Student ID: ");
        LehrerID = teacherID.nextLong();

        try {
            registrationSystemController.controller_addTeacher(PersonID, LehrerID);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

/*
    private void getAllStudentsFromFileUI() {
        System.out.println("Print Liste Studenten aus der Datei");
        for (Student student : registrationSystem.controller_getAllStudents()) {
            try {
                studentController.controller_update(student);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Problem mit der Aktualisierung der Datei");
            }
        }
    }

 */
/*
    private void ui_addCourse(){
        System.out.println("Add Course");
        Scanner name = new Scanner(System.in);
        Scanner idTeacher = new Scanner(System.in);
        Scanner idCourse = new Scanner(System.in);
        Scanner maxEnrollment = new Scanner(System.in);
        Scanner credits = new Scanner(System.in);
        String Name;
        long IdTeacher, IdCourse;
        int MaxEnrollment, Credits;

        System.out.println("Name der Course: ");
        Name = name.nextLine();
        System.out.println("Teacher ID: ");
        IdTeacher = idTeacher.nextLong();
        System.out.println("Course ID: ");
        IdCourse = idCourse.nextLong();
        System.out.println("Maximal Teilnehmer: ");
        MaxEnrollment = maxEnrollment.nextInt();
        System.out.println("Anzahl Credit: ");
        Credits = credits.nextInt();
        try {
            registrationSystemController.controller_addCourse(Name, IdTeacher, IdCourse, MaxEnrollment, Credits);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }





    }
*/

    public class Konsole {
        private RegistrationSystemController registrationSystem;


        public Konsole() {
            try {
                this.registrationSystem = new RegistrationSystemController();
            } catch (SQLException e) {
                System.out.println("Error");
            }
            System.out.println(" \nCase 1:Register " +
                    "\nCase 2:Print Courses " +
                    "\nCase 3:Print Persons " +
                    "\nCase 4:Print Students " +
                    "\nCase 5:Print Teachers " +
                    "\nCase 6:Courses mit free Places " +
                    "\nCase 7:Liste Students from a Course " +
                    "\nCase 8:Credit Number change " +
                    "\nCase 9:Sort Liste Students " +
                    "\nCase 10:Sort Liste Courses " +
                    "\nCase 11:Filter Liste Students " +
                    "\nCase 12:Filter Liste Courses " +
                    "\nCase 13:Add Course " +
                    "\nCase 14:Add Person " +
                    "\nCase 15:Add Student " +
                    "\nCase 16:Add Teacher" +
                    "\nCase 0:Exit\n");

            Scanner command = new Scanner(System.in);
            int commandInput;
            do {
                System.out.println("\nCommand: ");
                switch (commandInput = command.nextInt()) {
                    case 1:
                        ui_getAllCourses();
                        ui_getAllStudents();
                        ui_register();
                        break;
                    case 2:
                        ui_getAllCourses();
                        break;
                    case 3:
                        ui_getAllPersons();
                        break;
                    case 4:
                        ui_getAllStudents();
                        break;
                    case 5:
                        ui_getAllLehrer();
                        break;
                    case 6:
                        ui_retrieveCoursesWithFreePlaces();
                        break;
                    case 7:
                        ui_getAllCourses();
                        ui_retrieveStudentsEnrolledForACourse();
                        break;
                    case 8:
                        ui_getAllCourses();
                        ui_changeCreditFromACourse();
                        break;
                    case 9:
                        System.out.println("Sort Liste Students nach 'Person ID'");
                        ui_sortListeStudenten();
                        break;
                    case 10:
                        System.out.println("Sort Liste Courses nach 'Name'");
                        ui_sortListeCourses();
                        break;
                    case 11:
                        System.out.println("Filter Students mit Anzahl der Vorlesungen >= 2");
                        ui_filterListeStudenten();
                        break;
                    case 12:
                        System.out.println("Filter Courses  mit maximal Enrollment > 30");
                        ui_filterListeCourses();
                        break;
                    case 13:
                        ui_addCourse();
                        break;
                    case 14:
                        ui_addPerson();
                        break;
                    case 15:
                        ui_addStudent();
                        break;
                    case 16:
                        ui_addTeacher();
                        break;
                    case 0:
                        System.out.println("Exit!");
                        break;
                }

            } while (commandInput != 0);
        }

        private void ui_register() {
            System.out.println("Register");
            Scanner idCourse = new Scanner(System.in);
            Scanner idStudent = new Scanner(System.in);
            long CourseID, StudentID;

            System.out.println("Course ID: ");
            CourseID = idCourse.nextLong();
            System.out.println("Student ID: ");
            StudentID = idStudent.nextLong();
            try {
                registrationSystem.controller_register(CourseID, StudentID);
            } catch (RegisterException | SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
        private void ui_getAllCourses() {
            System.out.println("Print Liste Courses");
            try {
                this.registrationSystem.controller_getAllCourses()
                        .forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

        private void ui_getAllPersons(){
            System.out.println("Print Liste Persons");
            try {
                this.registrationSystem.controller_getAllPersons()
                        .forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_getAllStudents(){
            System.out.println("Print Liste Students");
            try {
                this.registrationSystem.controller_getAllStudents()
                        .forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_getAllLehrer(){
            System.out.println("Print Liste Teachers");
            try {
                this.registrationSystem.controller_getAllTeacher()
                        .forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        private void ui_retrieveCoursesWithFreePlaces(){
            System.out.println("Courses mit freie Plätze");
            try {
                for (Map.Entry map: registrationSystem.controller_retrieveCoursesWithFreePlaces().entrySet()) {
                    System.out.println(map.getKey() + " " + map.getValue());
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_retrieveStudentsEnrolledForACourse(){
            System.out.println("Print Liste Students von einer Vorlesung");
            Scanner idCourse = new Scanner(System.in);
            long CourseId;

            System.out.println("Course ID: ");
            CourseId = idCourse.nextLong();
            try {
                for (Long student:registrationSystem.controller_retrieveStudentsEnrolledForACourse(CourseId)) {
                    System.out.println(student);
                }
            } catch (ExistException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_changeCreditFromACourse(){
            System.out.println("Credit Anzahl ändern");
            Scanner idCourse = new Scanner(System.in);
            Scanner credits = new Scanner(System.in);
            long CourseID;
            int newCredit;

            System.out.println("Course ID: ");
            CourseID = idCourse.nextLong();
            System.out.println("New Credits: ");
            newCredit = credits.nextInt();
            try {
                registrationSystem.controller_changeCreditFromACourse(CourseID, newCredit);
            } catch (RegisterException | ExistException | SQLException | IOException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_sortListeStudenten(){
            System.out.println("Sort Liste Students");
            try {
                this.registrationSystem.controller_sortListeStudents()
                        .forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_sortListeCourses(){
            System.out.println("Sort Liste Courses");
            try {
                this.registrationSystem.controller_sortListeCourses()
                        .forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_filterListeStudenten(){
            System.out.println("Filter Liste Students");
            try {
                this.registrationSystem.controller_filterListeStudenten()
                        .forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_filterListeCourses(){
            System.out.println("Filter Liste Courses");
            try {
                this.registrationSystem.controller_filterListeCourses()
                        .forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_addPerson(){
            System.out.println("Add Person");
            Scanner vorname = new Scanner(System.in);
            Scanner nachname = new Scanner(System.in);
            Scanner id = new Scanner(System.in);
            String Vorname, Nachname;
            long Id;

            System.out.println("ID: ");
            Id = id.nextLong();
            System.out.println("Vorname: ");
            Vorname = vorname.nextLine();
            System.out.println("Nachname: ");
            Nachname = nachname.nextLine();
            try {
                registrationSystem.controller_addPerson(Id, Vorname, Nachname);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private void ui_addStudent(){
            System.out.println("Add Student");
            Scanner studentID = new Scanner(System.in);
            Scanner personID = new Scanner(System.in);
            long StudentID, PersonID;

            System.out.println("Person ID: ");
            PersonID = personID.nextLong();
            System.out.println("Student ID: ");
            StudentID = studentID.nextLong();

            try {
                registrationSystem.controller_addStudent(PersonID, StudentID);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }


        private void ui_addTeacher(){
            System.out.println("Add Teacher");
            Scanner teacherID = new Scanner(System.in);
            Scanner personID = new Scanner(System.in);
            long TeacherID, PersonID;

            System.out.println("Person ID: ");
            PersonID = personID.nextLong();
            System.out.println("Student ID: ");
            TeacherID = teacherID.nextLong();

            try {
                registrationSystem.controller_addTeacher(PersonID, TeacherID);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

        private void ui_addCourse(){
            System.out.println("Add Course");
            Scanner name = new Scanner(System.in);
            Scanner idTeacher = new Scanner(System.in);
            Scanner idCourse = new Scanner(System.in);
            Scanner maxEnrollment = new Scanner(System.in);
            Scanner credits = new Scanner(System.in);
            String Name;
            long IdTeacher, IdCourse;
            int MaxEnrollment, Credits;

            System.out.println("Name der Course: ");
            Name = name.nextLine();
            System.out.println("Teacher ID: ");
            IdTeacher = idTeacher.nextLong();
            System.out.println("Course ID: ");
            IdCourse = idCourse.nextLong();
            System.out.println("Maximal Teilnehner: ");
            MaxEnrollment = maxEnrollment.nextInt();
            System.out.println("Anzahl Credit: ");
            Credits = credits.nextInt();
            try {
                registrationSystem.controller_addCourse(Name, IdTeacher, IdCourse, MaxEnrollment, Credits);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }