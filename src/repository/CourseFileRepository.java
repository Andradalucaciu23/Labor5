/*package repository;

import model.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CourseFileRepository implements CrudRepository<Course> {
    protected ObjectOutputStream objectOutputStream;
    protected FileOutputStream fileOutputStream;
    protected ObjectInputStream objectInputStream;
    protected FileInputStream fileInputStream;
    protected String fileName;
    protected List<Course> repoList;

    public CourseFileRepository() {
        super();
        this.fileName = "src//vorlesung.ser";
        repoList = new ArrayList<>();
    }

    public CourseFileRepository(String fileName) throws IOException {
        super();
        this.fileName = fileName;
        repoList = new ArrayList<>();
        this.fileOutputStream = new FileOutputStream(fileName);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
        this.fileInputStream = new FileInputStream(fileName);
        this.objectInputStream = new ObjectInputStream(fileInputStream);
    }


    public List<Course> getRepositoryList() {
        return repoList;
    }


    public void writeObject(ObjectOutputStream outputStream, Course entity) throws IOException {
        outputStream.writeObject(entity);
    }


    public Object readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        Course entity;
        entity = (Course) inputStream.readObject();

        return entity;
    }


    @Override
    public Course findOne(int id) throws IOException, ClassNotFoundException {
        if (fileInputStream.available() <= 0) {
            for (Course student : repoList) {
                writeObject(objectOutputStream, student);
            }
        }

        List<Course> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            Course entity = (Course) objectInputStream.readObject();
            if (entity.getCourseID() == id) {
                list.add(entity);
            }

        }
        return list.get(list.size() - 1);
    }


    @Override
    public List<Course> findAll() throws IOException, ClassNotFoundException {
        if (fileInputStream.available() <= 0) {
            for (Course course : repoList) {
                writeObject(objectOutputStream, course);
            }
        }

        return repoList;
    }


    @Override
    public Course save(Course entity) throws IOException {
        repoList.add(entity);
        if (fileInputStream.available() <= 0) {
            for (Course course : repoList) {
                writeObject(objectOutputStream, course);
            }
        }
        return entity;
    }


    @Override
    public void delete(Course entity) throws IOException {
        if (fileInputStream.available() <= 0) {
            for (Course course : repoList) {
                writeObject(objectOutputStream, course);
            }
        }
        repoList.remove(entity);
    }


    @Override
    public Course update(Course entity) throws IOException, ClassNotFoundException {
        Course courseToUpdate = this.repoList.stream()
                .filter(course -> course.getCourseID() == entity.getCourseID())
                .findFirst()
                .orElseThrow();

        courseToUpdate.setName(entity.getName());
        courseToUpdate.setTeacherID(entity.getTeacherID());
        courseToUpdate.setMaxEnrollment(entity.getMaxEnrollment());
        courseToUpdate.setSttudentsEnrolled(entity.getSttudentsEnrolled());
        courseToUpdate.setCredits(entity.getCredits());

        if (fileInputStream.available() <= 0) {
            for (Course course : repoList) {
                writeObject(objectOutputStream, course);
            }
        }

        return courseToUpdate;
    }
}
*/