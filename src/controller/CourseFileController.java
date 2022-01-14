
/*package controller;

import model.Course;
import repository.CourseFileRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class CourseFileController {
    private final CourseFileRepository courseFileRepository;

    public CourseFileController(){
        courseFileRepository = new CourseFileRepository();
    }

    public CourseFileController(String fileName) throws IOException {
        courseFileRepository = new CourseFileRepository(fileName);
    }

    public void controller_writeObject(ObjectOutputStream outputStream, Course entity) throws IOException {
        courseFileRepository.writeObject(outputStream, entity);
    }

    public Object controller_readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        return courseFileRepository.readObject(inputStream);
    }

    public void controller_findOne(int id) throws IOException, ClassNotFoundException {
        courseFileRepository.findOne(id);
    }

    public List<Course> controller_findAll() throws IOException, ClassNotFoundException {
        return courseFileRepository.findAll();
    }


    public void controller_save(String Name, long IdTeacher, long IdCourse, int MaxEnrollment, int Credits) throws IOException {
        courseFileRepository.save(new Course(Name, IdTeacher, IdCourse, MaxEnrollment, Credits));
    }


    public void controller_delete(Long Id) throws IOException {
        Course courseToDelete = null;
        for (Course course: courseFileRepository.getRepositoryList()) {
            if (course.getCourseID() == Id){
                courseToDelete = new Course(course.getName(), course.getTeacherID(), course.getCourseID(), course.getMaxEnrollment(), course.getCredits());
            }
        }
        courseFileRepository.delete(courseToDelete);
    }

    public void controller_update(Course entity) throws IOException, ClassNotFoundException {
        courseFileRepository.update(entity);
    }
}
     */