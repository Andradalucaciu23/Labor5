package repository;
import model.Course;
import model.Person;
import model.Student;
import model.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import exception.DeleteCourseFromTeacherException;
import exception.ExistException;
import exception.RegisterException;

import java.sql.SQLException;


//public class RegistrationSystem {
    /*
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    /**
     * ein neues Obj von Typ "RegistrationSystem"


    public RegistrationSystem() {
        this.courseRepository = new CourseRepository();
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();
    }

    /**
     * @return alle Elem aus der studentRepository

    public StudentRepository getStudentRepository() {
        return this.studentRepository;
    }

    /**
     * @return alle Elem aus der courseRepository

    public CourseRepository getCourseRepository() {
        return this.courseRepository;
    }

    /**
     * @return alle Elem aus der teacherRepository

    public TeacherRepository getTeacherRepository() {
        return this.teacherRepository;
    }


    /**
     * @param course  Obj von Typ "Course"
     * @param student Obj von Typ "Student"
     * @return der Student meldet sich fur eine gegebene Course
     * @throws IOException falls der Student oder das Course nich in der Repository existiert
     *                     falls es kein frei Platz existiert
     *                     falls der Azhal der Credits des Student > 30 ist
     *                     und dann wie aktualisieren die Listen der Studenten, Courses und LehrerRepository

    public boolean register(Course course, Student student) throws IOException {
        boolean okCourse = false;
        boolean okStudent = false;
        for (int i = 0; i < this.courseRepository.repoList.size(); i++) {
            if (course.getCourseID() == this.courseRepository.repoList.get(i).getCourseID()) {
                okCourse = true;
                break;
            }
        }

        for (int i = 0; i < this.studentRepository.repoList.size(); i++) {
            if (student.getStudentID() == this.studentRepository.repoList.get(i).getStudentID()) {
                okStudent = true;
                break;
            }
        }

        if (!okCourse || !okStudent) {
            throw new IOException();
        }

        if (course.getMaxEnrollment() <= course.getSttudentsEnrolled().size())
            throw new IOException();
        else if (student.getTotalCredits() + course.getCredits() > 30)
            throw new IOException();
        else {
            boolean okListeCourses = false;
            boolean okListeStudents = false;
            List<Long> listCourses = new ArrayList<>();
            for (int i = 0; i < studentRepository.repoList.size(); i++) {
                if (studentRepository.repoList.get(i).getStudentID() == student.getStudentID()) {
                    for (int j = 0; j < studentRepository.repoList.get(i).getEnrolledCourses().size(); j++) {
                        listCourses.add(studentRepository.repoList.get(i).getEnrolledCourses().get(j));
                        if (studentRepository.repoList.get(i).getEnrolledCourses().get(j) == course.getCourseID()) {
                            okListeCourses = true;
                        }
                    }
                }
            }

            if (!okListeCourses) {
                listCourses.add(course.getCourseID());
            }

            List<Long> listStudents = new ArrayList<>();
            for (int i = 0; i < courseRepository.repoList.size(); i++) {
                if (courseRepository.repoList.get(i).getCourseID() == course.getCourseID()) {
                    for (int j = 0; j < courseRepository.repoList.get(i).getSttudentsEnrolled().size(); j++) {
                        listStudents.add(courseRepository.repoList.get(i).getSttudentsEnrolled().get(j));
                        if (courseRepository.repoList.get(i).getSttudentsEnrolled().get(j) == student.getStudentID()) {
                            okListeStudents = true;
                        }
                    }
                }
            }

            if (okListeStudents) {
                listStudents.add(student.getStudentID());
            }

            Course newCourse = new Course(course.getName(), course.getTeacherID(), course.getCourseID(), course.getMaxEnrollment(), listStudents, course.getCredits());

            Student newStudent = new Student(student.getVorname(), student.getNachname(), student.getStudentID(), student.getTotalCredits() + course.getCredits(), listCourses);

            courseRepository.update(newCourse);
            studentRepository.update(newStudent);
        }


        for (int i = 0; i < teacherRepository.repoList.size(); i++) {
            updateTeacherCourseList(teacherRepository.repoList.get(i).getTeacherID());
        }

        return true;
    }


    /**
     * @param CourseID  eine long Zahl, die ein Course ID entspricht
     * @param StudentID eine long Zahl, die ein Student ID enspricht
     * @return
     * @throws IOException wir aktualisieren dann die Liste der Studenten, Courses Repository

    public boolean register(long CourseID, long StudentID) throws IOException {
        boolean okCourse = false;
        boolean okStudent = false;
        int iCourse = 0;
        int iStudent = 0;

        for (int i = 0; i < this.courseRepository.repoList.size(); i++) {
            if (CourseID == this.courseRepository.repoList.get(i).getCourseID()) {
                iCourse = i;
                okCourse = true;
                break;
            }
        }

        for (int i = 0; i < this.studentRepository.repoList.size(); i++) {
            if (StudentID == this.studentRepository.repoList.get(i).getStudentID()) {
                iStudent = i;
                okStudent = true;
                break;
            }
        }

        if (!okCourse || !okStudent) {
            throw new IOException();
        }

        Course course = this.courseRepository.repoList.get(iCourse);
        Student student = this.studentRepository.repoList.get(iStudent);

        register(course, student);
        return true;
    }

    /**
     * @param CourseID
     * @param StudentID wir loschen das Course aus der Course Liste der Studenten
     *                  wie loschen der Student aus der Liste der Course
     *                  und dann wir aktualisieren die Lsten aus der Student und Course Repository

    public void unregister(long CourseID, long StudentID) {
        int iCourse = 0;
        for (int i = 0; i < this.courseRepository.repoList.size(); i++) {
            if (this.courseRepository.repoList.get(i).getCourseID() == CourseID) {
                iCourse = i;
                break;
            }
        }

        Course course = this.courseRepository.repoList.get(iCourse);
        List<Long> listCourses = new ArrayList<>();
        List<Long> listStudents = new ArrayList<>();

        for (int i = 0; i < course.getSttudentsEnrolled().size(); i++) {
            if (course.getSttudentsEnrolled().get(i) != StudentID)
                listStudents.add(course.getSttudentsEnrolled().get(i));
        }

        for (int i = 0; i < this.studentRepository.repoList.size(); i++) {
            if (this.studentRepository.repoList.get(i).getStudentID() == StudentID) {
                Student student = this.studentRepository.repoList.get(i);
                for (int j = 0; j < student.getEnrolledCourses().size(); j++) {
                    if (student.getEnrolledCourses().get(j) == CourseID) {
                        for (int k = 0; k < student.getEnrolledCourses().size(); k++) {
                            if (student.getEnrolledCourses().get(k) != CourseID) {
                                listCourses.add(student.getEnrolledCourses().get(k));
                            }
                        }
                        Student newStudent = new Student(student.getVorname(), student.getNachname(), student.getStudentID(), student.getTotalCredits() - course.getCredits(), listCourses);
                        this.studentRepository.update(newStudent);
                        break;
                    }
                }
            }
        }
        Course newCourse = new Course(course.getName(), course.getTeacherID(), course.getCourseID(), course.getMaxEnrollment(), listStudents, course.getCredits());
        this.courseRepository.update(newCourse);
    }

    /**
     * @param TeacherID eine long Anzahl, die ein Teachr ID entspricht
     *                  wir aktualisieren die Course Liste des Teachers

    private void updateTeacherCourseList(long TeacherID) {
        List<Long> listCourses = new ArrayList<>();
        for (int i = 0; i < this.courseRepository.repoList.size(); i++) {
            if (this.courseRepository.repoList.get(i).getTeacherID() == TeacherID) {
                listCourses.add(this.courseRepository.repoList.get(i).getCourseID());
            }
        }
        int iTeacher = 0;
        for (int i = 0; i < this.teacherRepository.repoList.size(); i++) {
            if (this.teacherRepository.repoList.get(i).getTeacherID() == TeacherID) {
                iTeacher = i;
            }
        }

        this.teacherRepository.update(new Teacher(this.teacherRepository.repoList.get(iTeacher).getVorname(), this.teacherRepository.repoList.get(iTeacher).getNachname(), TeacherID, listCourses));
    }

    /**
     * @return Courses with free Places und deren Anzahl

    public HashMap<Integer, Course> retrieveCoursesWithFreePlaces() {
        HashMap<Integer, Course> map = new HashMap<Integer, Course>();
        int freePlace = 0;
        for (Course c : courseRepository.findAll()) {
            if (c.getMaxEnrollment() > c.getSttudentsEnrolled().size()) {
                freePlace = c.getMaxEnrollment() - c.getSttudentsEnrolled().size();
                map.put(freePlace, c);
            }
        }
        return map;
    }

    /**
     * @param CourseID
     * @return eine Liste von Students, die an einer angegebene Course teilnehmen

    public List<Long> retireveStudentsEnrolledForACourse(long CourseID) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < this.courseRepository.repoList.size(); i++) {
            if (this.courseRepository.repoList.get(i).getCourseID() == CourseID) {
                list.addAll(this.courseRepository.repoList.get(i).getSttudentsEnrolled());
                break;
            }
        }
        return list;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Teacher> getAllTeacher() {
        for (int i = 9; i < teacherRepository.repoList.size(); i++) {
            updateTeacherCourseList(teacherRepository.repoList.get(i).getTeacherID());
        }
        return teacherRepository.findAll();
    }

    /**
     *
     * @param CourseID
     * @param newCredit die neue Anzahl von Credits
     * @return wir andern die Anzahl der Credits; uregister lle Students aus der Course; aktualisieren das Course, register die alte Students zu der Course
     * @throws IOException


    public boolean changeCreditFromACourse(long CourseID, int newCredit) throws IOException {
        for (int i = 0; i < courseRepository.repoList.size(); i++) {
            if (courseRepository.repoList.get(i).getCourseID() == CourseID) {
                if (courseRepository.repoList.get(i).getCredits() == newCredit) {
                    return true;
                } else {
                    Course course = this.courseRepository.repoList.get(i);
                    Course newCourse = new Course(course.getName(), course.getTeacherID(), course.getCourseID(), course.getMaxEnrollment(), course.getSttudentsEnrolled(), newCredit);

                    for (int j = 0; j < course.getSttudentsEnrolled().size(); j++) {
                        unregister(course.getCourseID(), course.getSttudentsEnrolled().get(j));
                    }

                    this.courseRepository.update(newCourse);

                    List<Long> listStudents = new ArrayList<>();
                    for (int j = 0; j < course.getSttudentsEnrolled().size(); j++) {
                        if (register(course.getCourseID(), course.getSttudentsEnrolled().get(j))) {
                            listStudents.add(course.getSttudentsEnrolled().get(j));
                        }
                    }

                    Course newCourse2 = new Course(course.getName(), course.getTeacherID(), course.getCourseID(), course.getMaxEnrollment(), listStudents, newCredit);

                    return true;
                }
            }
        }
        return false;
    }


    /**
     *
     * @param TeacherID
     * @param CourseID
     * @return wir loschen ein Course aus der Liste des Courses von einem Lehrer

    public boolean deleteCourseFromATeacher(long TeacherID, long CourseID) {
        int iCourse = 0;
        for (int i = 0; i < this.courseRepository.repoList.size(); i++) {
            if (this.courseRepository.repoList.get(i).getCourseID() == CourseID) {
                iCourse = i;
                if (this.courseRepository.repoList.get(i).getTeacherID() != TeacherID) {
                    return false;
                }
            }
        }

        for (int i = 0; i < this.courseRepository.repoList.get(iCourse).getSttudentsEnrolled().size(); i++) {
            unregister(CourseID, this.courseRepository.repoList.get(iCourse).getSttudentsEnrolled().get(i));
        }

        for (int i = 0; i < this.teacherRepository.repoList.size(); i++) {
            if (this.teacherRepository.repoList.get(i).getTeacherID() == TeacherID) {
                List<Long> listCourses = new ArrayList<>();
                for (int j = 0; j < this.teacherRepository.repoList.get(i).getCourses().size(); j++) {
                    if (teacherRepository.repoList.get(i).getCourses().get(j) != CourseID) {
                        listCourses.add(this.teacherRepository.repoList.get(i).getCourses().get(j));
                    }
                }
                Teacher teacher = this.teacherRepository.repoList.get(i);
                Teacher newTeacher = new Teacher(teacher.getVorname(), teacher.getNachname(), teacher.getTeacherID(), listCourses);

                this.teacherRepository.update(newTeacher);


            }
        }

        this.courseRepository.delete(this.courseRepository.repoList.get(iCourse));
        return true;

    }
    /*

    private final VorlesungRepository vorlesungRepository;
    private final PersonRepository personRepository;
    private final StudentRepository studentRepository;
    private final LehrerRepository lehrerRepository;
    private final EnrolledRepository enrolledRepository;

    /**
     * wir erstellen ein neues Objekt von Typ RegistrationSystem
     * @throws SQLException falls man Repositories nicht öffnen kann
     */
    public class RegistrationSystem {
        private final CourseRepository courseRepository;
        private final PersonRepository personRepository;
        private final StudentRepository studentRepository;
        private final TeacherRepository teacherRepository;
        private final EnrolledRepository enrolledRepository;


        public RegistrationSystem() throws SQLException {
            this.courseRepository = new CourseRepository();
            this.personRepository = new PersonRepository();
            this.studentRepository = new StudentRepository();
            this.teacherRepository = new TeacherRepository();
            this.enrolledRepository = new EnrolledRepository();
        }

        public CourseRepository getCourseRepository(){
        return this.courseRepository;
    }


    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public StudentRepository getStudentRepository(){
        return this.studentRepository;
    }

    public TeacherRepository getTeacherRepository(){
        return this.teacherRepository;
    }


    public EnrolledRepository getEnrolledRepository() {
        return enrolledRepository;
    }


    public boolean register(long CourseID, long StudentID) throws RegisterException, SQLException {
        String message = "Unerfüllte Bedingungen: ";
        Course course = this.getCourseRepository().findOne(CourseID);
        Student student = this.getStudentRepository().findOne(StudentID);

        if (course == null || student == null)
            throw new RegisterException(message + "Der Student und/oder die Course sind/ist nicht in der Liste.");

        if (this.getCourseRepository().enrolledStudents(course).size() > course.getMaxEnrollment())
            throw new RegisterException(message + "Keine freie Plätze.");
        else if (this.getStudentRepository().credits(student) + course.getCredits() > 30)
            throw new RegisterException(message + "Anzahl von Credits übersprungen.");
        else if (this.getEnrolledRepository().findOne(course.getCourseID(), student.getStudentID()))
            throw new RegisterException(message + "Der Student nimmt an dieser Course teil.");
        else
            this.getEnrolledRepository().save(CourseID, StudentID);

        return true;
    }

    public void unregister(long CourseID, long StudentID) throws RegisterException, SQLException {
        String message = "Unerfüllte Bedingungen: ";
        Course course = this.getCourseRepository().findOne(CourseID);
        Student student = this.getStudentRepository().findOne(StudentID);

        if (course == null || student == null)
            throw new RegisterException(message + "Der Student und die Course sind nicht in der Liste.");

        this.getEnrolledRepository().delete(CourseID, StudentID);
    }


    /**
     * @return folosim funcia de hash map (pt stocare de tip cheie-valoare) si calculam nr de locuri libere prin formula :
     * nr maxim de student – studentii inscrisi la respectivul curs
     * @throws ExistException
     * @throws SQLException
     */
    public HashMap<Integer, Long> retrieveCoursesWithFreePlaces() throws SQLException {
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();
        for (Course course: this.getCourseRepository().findAll()){
            map.put(course.getMaxEnrollment() - this.getCourseRepository().enrolledStudents(course).size(), course.getCourseID());
        }

        return map;
    }


    public List<Long> retrieveStudentsEnrolledForACourse(long CourseID) throws ExistException, SQLException {
        Course course = this.getCourseRepository().findOne(CourseID);
        if (course == null){
            throw new ExistException("Die Course ist nicht in der Liste.");
        }

        return this.getCourseRepository().enrolledStudents(course);
    }


    public List<Course> getAllCourses() throws SQLException {
        List<Course> courseList = new ArrayList<>();
        getCourseRepository().findAll()
                .forEach(course -> {
                    try {
                        courseList
                                .add(new Course(course.getName(),
                                        course.getTeacherID(),
                                        course.getCourseID(),
                                        course.getMaxEnrollment(),
                                        getCourseRepository().enrolledStudents(course),
                                        getCourseRepository().findOne(course.getCourseID()).getCredits()
                                ));
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                });

        return courseList;
    }


    public List<Person> getAllPersons() throws SQLException {
        List<Person> personList = new ArrayList<>();
        this.getPersonRepository().findAll()
                .forEach(person -> personList
                        .add(new Person(person.getPersonID(),
                                person.getVorname(),
                                person.getNachname())));
        return personList;
    }


    public List<Student> getAllStudents() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        this.getStudentRepository().findAll()
                .forEach(student ->
                {
                    try {
                        studentList
                                .add(new Student(new Person(student.getPersonID(), student.getVorname(), student.getNachname()),
                                        student.getStudentID(),
                                        this.getStudentRepository().credits(student),
                                        this.getStudentRepository().enrolledCourses(student)));
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                });

        return studentList;
    }


    public List<Teacher> getAllTeachers() throws SQLException {
        List<Teacher> teacherList = new ArrayList<>();
        this.getTeacherRepository().findAll()
                .forEach(teacher ->
                {
                    try {
                        teacherList
                                .add(new Teacher(new Person(teacher.getPersonID(), teacher.getVorname(), teacher.getNachname()),
                                        teacher.getTeacherID(),
                                        this.getTeacherRepository().enrolledCourses(teacher)));
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                });
        return teacherList;
    }

    /**
     *
     * @param CourseID
     * @param newCredit
     * @return  -introducem id ul nou si nr nou de credite si cu update se va schimba nr d credite.
     * Avem si exceptia in care nr de credite depaseste nr 30 si atunci ii face unregister (sau asa ar trebui))
     * nu stiu de ce imi schimba tot din doua in doua cursuri
     * @throws RegisterException
     * @throws ExistException
     * @throws SQLException
     */
    public boolean changeCreditFromACourse(long CourseID, int newCredit) throws RegisterException, ExistException, SQLException {
        String message = "Unerfüllte Bedingungen: ";
        Course course = this.getCourseRepository().findOne(CourseID);
        if (course == null)
            throw new RegisterException(message + "Die Course ist nicht in der Liste.");

        Course newCourse = new Course(course.getName(),
                course.getTeacherID(),
                course.getCourseID(),
                course.getMaxEnrollment(),
                newCredit);
        this.getCourseRepository().update(newCourse);

        Student student;
        for (Long studentID: this.getCourseRepository().enrolledStudents(course)) {
            student = this.getStudentRepository().findOne(studentID);
            if (this.getStudentRepository().credits(student) > 30)
                unregister(CourseID, studentID);

        }

        throw new ExistException("Die Anzahl der Credits wurden geändert.");
    }


    public void deleteCourseFromLehrer(long TeacherID, long CourseID) throws DeleteCourseFromTeacherException, RegisterException, SQLException {
        String message = "Unerfüllte Bedingungen: ";
        Teacher teacher = this.getTeacherRepository().findOne(TeacherID);
        Course course = this.getCourseRepository().findOne(CourseID);

        if (teacher == null || course == null)
            throw new DeleteCourseFromTeacherException(message + "Der Teacher und/oder die Course sind/ist nicht in der Liste.");

        if (course.getTeacherID() != teacher.getTeacherID())
            throw new DeleteCourseFromTeacherException(message + "Der Teacher unterrichtet nicht diese Course.");

        this.getCourseRepository().enrolledStudents(course)
                .forEach(student -> {
                    try {
                        unregister(course.getCourseID(), student);
                    } catch (RegisterException | SQLException e) {
                        System.out.println(message + e.getMessage());
                    }
                });

        this.getCourseRepository().delete(course);
    }
}





