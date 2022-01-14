package repository;

import model.Course;

import connection.ConnectionMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CourseRepository implements CrudRepository<Course> {
    /*
    public CourseRepository(){
        super();
    }

    @Override
    public Course update(Course entity){
        Course courseToUpdate = this.repoList.stream()
                .filter(course -> course.getCourseID() == entity.getCourseID())
                .findFirst()
                .orElseThrow();

        courseToUpdate.setName(entity.getName());
        courseToUpdate.setTeacherID(entity.getTeacherID());
        courseToUpdate.setMaxEnrollment(entity.getMaxEnrollment());
        courseToUpdate.setSttudentsEnrolled(entity.getSttudentsEnrolled());
        courseToUpdate.setCredits(entity.getCredits());

        return courseToUpdate;
    }

     */
    static final String QUERY_SELECT = "SELECT * FROM COURSE";
    static final String QUERY_FIND = "SELECT * FROM COURSE WHERE courseID = ?";
    static final String QUERY_INSERT = "INSERT INTO COURSE VALUES(?, ?, ?, ?, ?)";
    static final String QUERY_DELETE = "DELETE FROM COURSE WHERE courseID = ?";
    static final String QUERY_UPDATE = "UPDATE COURSE SET name = ?, teacherID = ?, maxEnrollment = ?, credits = ? where courseID = ?";
    static final String QUERY_STUDENTS = "SELECT * FROM COURSE " +
            "INNER JOIN ENROLLED ON COURSE.courseID = ENROLLED.courseID " +
            "WHERE COURSE.courseID = ?";
    private java.sql.Connection connection;
    private java.sql.Statement statement;
    private ResultSet resultSet;

    public CourseRepository() throws SQLException {
        super();
        this.connection = new ConnectionMySQL().getConnection();
        this.statement = connection.createStatement();
    }

    @Override
    public Course findOne(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND);
        preparedStatement.setLong(1, id);
        this.resultSet = preparedStatement.executeQuery();

        Course course = null;
        while (resultSet.next()){
            course = new Course(resultSet.getString("name"), resultSet.getLong("teacherID"), resultSet.getLong("courseID"), resultSet.getInt("maxEnrollment"), resultSet.getInt("credits"));
        }


        return course;
    }

    @Override
    public List<Course> findAll() throws SQLException {
        List<Course> courseList = new ArrayList<>();
        this.resultSet = statement.executeQuery(QUERY_SELECT);

        Course course = null;
        while (resultSet.next()){
            course = new Course(resultSet.getString("name"), resultSet.getLong("teacherID"), resultSet.getLong("courseID"), resultSet.getInt("maxEnrollment"), resultSet.getInt("credits"));
            courseList.add(course);
        }

        return courseList;
    }

    @Override
    public Course save(Course entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setLong(2, entity.getTeacherID());
        preparedStatement.setLong(3, entity.getCourseID());
        preparedStatement.setInt(4, entity.getMaxEnrollment());
        preparedStatement.setInt(5, entity.getCredits());

        preparedStatement.executeUpdate();

        return entity;
    }

    @Override
    public void delete(Course entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
        preparedStatement.setLong(1, entity.getCourseID());

        preparedStatement.executeUpdate();
    }

    @Override
    public Course update(Course entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setLong(2, entity.getTeacherID());
        preparedStatement.setInt(3, entity.getMaxEnrollment());
        preparedStatement.setInt(4, entity.getCredits());
        preparedStatement.setLong(5, entity.getCourseID());

        preparedStatement.executeUpdate();

        return entity;
    }

    public List<Long> enrolledStudents(Course entity) throws SQLException{
        List<Long> list = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_STUDENTS);
        preparedStatement.setLong(1, entity.getCourseID());
        this.resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            list.add(resultSet.getLong("studentID"));
        }

        return list;
    }
}
