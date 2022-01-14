
/*package controller;

import model.Student;
import repository.StudentFileRepository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class StudentFileController {
    private final StudentFileRepository studentFileRepository;

    public StudentFileController(){
        studentFileRepository = new StudentFileRepository();
    }

    public StudentFileController(String fileName) throws IOException {
        studentFileRepository = new StudentFileRepository(fileName);
    }

    public void controller_writeObject(ObjectOutputStream outputStream, Student entity) throws IOException {
        studentFileRepository.writeObject(outputStream, entity);
    }

    public Object controller_readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        return studentFileRepository.readObject(inputStream);
    }

    public void controller_findOne(int id) throws IOException, ClassNotFoundException {
        studentFileRepository.findOne(id);
    }

    public List<Student> controller_findAll() throws IOException, ClassNotFoundException {
        return studentFileRepository.findAll();
    }

    public void controller_save(String Vorname, String Nachname, Long Id) throws IOException {
        studentFileRepository.save(new Student(Vorname, Nachname, Id));
    }

    public void controller_delete(Long Id) throws IOException {
        Student studentToDelete = null;
        for (Student student: studentFileRepository.getRepositoryList()) {
            if (student.getStudentID() == Id){
                studentToDelete = new Student(student.getVorname(), student.getNachname(), Id);
            }
        }
        studentFileRepository.delete(studentToDelete);
    }

    public void controller_update(Student entity) throws IOException, ClassNotFoundException {
        studentFileRepository.update(entity);
    }
}
*/