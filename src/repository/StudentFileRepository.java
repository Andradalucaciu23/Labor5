
/*package repository;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileRepository implements CrudRepository<Student> {
    protected ObjectOutputStream objectOutputStream;
    protected FileOutputStream fileOutputStream;
    protected ObjectInputStream objectInputStream;
    protected FileInputStream fileInputStream;
    protected String fileName;
    protected List<Student> repoList;

    public StudentFileRepository(){
        super();
        this.fileName = "src//student.ser";
        repoList = new ArrayList<>();
    }

    public StudentFileRepository(String fileName) throws IOException {
        super();
        this.fileName = fileName;
        repoList = new ArrayList<>();
        this.fileOutputStream = new FileOutputStream(fileName);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
        this.fileInputStream = new FileInputStream(fileName);
        this.objectInputStream = new ObjectInputStream(fileInputStream);
    }


    public List<Student> getRepositoryList() {
        return repoList;
    }


    public void writeObject(ObjectOutputStream outputStream, Student entity) throws IOException {
        outputStream.writeObject(entity);
    }


    public Object readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        Student entity;
        entity = (Student) inputStream.readObject();

        return entity;
    }
    @Override
    public Student findOne(int id) throws IOException, ClassNotFoundException {
        if (fileInputStream.available() <= 0)
        {
            for (Student student : repoList) {
                writeObject(objectOutputStream, student);
            }
        }

        List<Student> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            Student entity = (Student) objectInputStream.readObject();
            if (entity.getStudentID() == id) {
                list.add(entity);
            }

        }
        return list.get(list.size() - 1);
    }

    @Override
    public List<Student> findAll() throws IOException, ClassNotFoundException {
        if (fileInputStream.available() <= 0)
        {
            for (Student student : repoList) {
                writeObject(objectOutputStream, student);
            }
        }

        return repoList;
    }

    @Override
    public Student save(Student entity) throws IOException {
        repoList.add(entity);
        if (fileInputStream.available() <= 0)
        {
            for (Student student : repoList) {
                writeObject(objectOutputStream, student);
            }
        }
        return entity;
    }



    @Override
    public void delete(Student entity) throws IOException {
        if (fileInputStream.available() <= 0)
        {
            for (Student student : repoList) {
                writeObject(objectOutputStream, student);
            }
        }
        repoList.remove(entity);
    }


    @Override
    public Student update(Student entity) throws IOException, ClassNotFoundException {
        Student studentToUpdate = this.repoList.stream()
                .filter(student -> student.getStudentID() == entity.getStudentID())
                .findFirst()
                .orElseThrow();

        studentToUpdate.setVorname(entity.getVorname());
        studentToUpdate.setNachname(entity.getNachname());
        studentToUpdate.setTotalCredits(entity.getTotalCredits());
        studentToUpdate.setEnrolledCourses(entity.getEnrolledCourses());

        if (fileInputStream.available() <= 0)
        {
            for (Student student : repoList) {
                writeObject(objectOutputStream, student);
            }
        }

        return entity;
    }
}
*/