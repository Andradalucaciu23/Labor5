package repository;
import model.Person;
import model.Teacher;

import connection.ConnectionMySQL;
import model.Student;
import model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements CrudRepository<Teacher> {
    /*
    public TeacherRepository(){
        super();
    }

    /**
     *
     * @param entity ein Obj von Typ "Teacher"
     * @return aktualisierte Version des Obj


    @Override
    public Teacher update(Teacher entity){
        Teacher teacherToUpdate = this.repoList.stream()
                .filter(teacher -> teacher.getTeacherID() == entity.getTeacherID())
                .findFirst()
                .orElseThrow();
        teacherToUpdate.setVorname(entity.getVorname());
        teacherToUpdate.setNachname(entity.getNachname());
        teacherToUpdate.setCourses(entity.getCourses());

        return teacherToUpdate;
    }
    */

    static final String QUERY_SELECT = "SELECT * FROM TEACHER INNER JOIN PERSON ON TEACHER.personID = PERSON.personID";
    static final String QUERY_FIND = "SELECT * FROM TEACHER INNER JOIN PERSON ON TEACHER.personID = PERSON.personID WHERE teacherID = ?";
    static final String QUERY_INSERT = "INSERT INTO TEACHER VALUES(?, ?)";
    static final String QUERY_DELETE = "DELETE FROM TEACHER WHERE teacherID = ?";
    static final String QUERY_UPDATE = "UPDATE TEACHER SET personID = ? where teacherID = ?";
    static final String QUERY_COURSES = "SELECT * FROM TEACHER " +
            "INNER JOIN COURSE ON COURSE.teacherID = TEACHER.teacherID " +
            "WHERE TEACHER.teacherID = ?";
    private java.sql.Connection connection;
    private java.sql.Statement statement;
    private java.sql.ResultSet resultSet;

    public TeacherRepository() throws SQLException {
        super();
        this.connection = new ConnectionMySQL().getConnection();
        this.statement = connection.createStatement();
    }

    @Override
    public Teacher findOne(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND);
        preparedStatement.setLong(1, id);
        this.resultSet = preparedStatement.executeQuery();

        Teacher teacher = null;
        while (resultSet.next()){
            teacher = new Teacher(new Person(resultSet.getLong("personID"), resultSet.getString("vorname"), resultSet.getString("nachname")), resultSet.getLong("teacherID"));
        }

        return teacher;
    }

    @Override
    public List<Teacher> findAll() throws SQLException {
        List<Teacher> teacherList = new ArrayList<>();
        this.resultSet = statement.executeQuery(QUERY_SELECT);
        Teacher teacher;
        while (resultSet.next()){
            teacher = new Teacher(new Person(resultSet.getLong("personID"), resultSet.getString("vorname"), resultSet.getString("nachname")), resultSet.getLong("teacherID"));
            teacherList.add(teacher);
        }

        return teacherList;
    }

    @Override
    public Teacher save(Teacher entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
        preparedStatement.setLong(1, entity.getPersonID());
        preparedStatement.setLong(2, entity.getTeacherID());

        preparedStatement.executeUpdate();

        return entity;
    }

    @Override
    public void delete(Teacher entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
        preparedStatement.setLong(1, entity.getTeacherID());

        preparedStatement.executeUpdate();
    }

    @Override
    public Teacher update(Teacher entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
        preparedStatement.setLong(1, entity.getPersonID());
        preparedStatement.setLong(2, entity.getTeacherID());

        preparedStatement.executeUpdate();

        return entity;
    }

    public List<Long> enrolledCourses(Teacher entity) throws SQLException{
        List<Long> list = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_COURSES);
        preparedStatement.setLong(1, entity.getTeacherID());
        this.resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            list.add(resultSet.getLong("courseID"));
        }

        return list;
    }

}
