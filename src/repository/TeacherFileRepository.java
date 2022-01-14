/*package repository;

import model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherFileRepository implements CrudRepository<Teacher> {
    protected ObjectOutputStream objectOutputStream;
    protected FileOutputStream fileOutputStream;
    protected ObjectInputStream objectInputStream;
    protected FileInputStream fileInputStream;
    protected String fileName;
    protected List<Teacher> repoList;

    public TeacherFileRepository()
    {
        super();
    }

    public TeacherFileRepository(String fileName) throws IOException {
        super();
        this.fileName = fileName;
        repoList = new ArrayList<>();
        this.fileOutputStream = new FileOutputStream(fileName);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
        this.fileInputStream = new FileInputStream(fileName);
        this.objectInputStream = new ObjectInputStream(fileInputStream);
    }

    public List<Teacher> getRepositoryList(){
        return repoList;
    }


    public void writeObject(ObjectOutputStream outputStream, Teacher entity) throws IOException {
        outputStream.writeObject(entity);
    }


    public Object readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        Teacher entity;
        entity = (Teacher) inputStream.readObject();

        return entity;
    }


    @Override
    public Teacher findOne(int id) throws IOException, ClassNotFoundException {
        if (fileInputStream.available() <= 0)
        {
            for (Teacher teacher: repoList) {
                writeObject(objectOutputStream, teacher);
            }
        }

        List<Teacher> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            Teacher entity = (Teacher) objectInputStream.readObject();
            if (entity.getTeacherID() == id) {
                list.add(entity);
            }

        }
        return list.get(list.size() - 1);
    }


    @Override
    public List<Teacher> findAll() throws IOException, ClassNotFoundException {
        if (fileInputStream.available() <= 0)
        {
            for (Teacher teacher: repoList) {
                writeObject(objectOutputStream, teacher);
            }
        }

        return repoList;
    }


    @Override
    public Teacher save(Teacher entity) throws IOException {
        repoList.add(entity);
        if (fileInputStream.available() <= 0)
        {
            for (Teacher teacher : repoList) {
                writeObject(objectOutputStream, teacher);
            }
        }
        return entity;
    }


    @Override
    public void delete(Teacher entity) throws IOException {
        if (fileInputStream.available() <= 0)
        {
            for (Teacher teacher : repoList) {
                writeObject(objectOutputStream, teacher);
            }
        }
        repoList.remove(entity);
    }


    @Override
    public Teacher update(Teacher entity) throws IOException, ClassNotFoundException {
        Teacher teachertoUpdate = this.repoList.stream()
                .filter(lehrer -> lehrer.getTeacherID() == entity.getTeacherID())
                .findFirst()
                .orElseThrow();

        teachertoUpdate.setVorname(entity.getVorname());
        teachertoUpdate.setNachname(entity.getNachname());
        teachertoUpdate.setCourses(entity.getCourses());

        if (fileInputStream.available() <= 0)
        {
            for (Teacher teacher : repoList) {
                writeObject(objectOutputStream, teacher);
            }
        }

        return teachertoUpdate;
    }

}
*/
