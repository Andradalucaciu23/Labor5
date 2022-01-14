/*package controller;
import model.Teacher;
import repository.TeacherFileRepository;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TeacherFileController {
    public TeacherFileRepository teacherFileRepo;

    public TeacherFileController(){
        teacherFileRepo = new TeacherFileRepository();
    }

    public TeacherFileController(String filename) throws IOException{
        teacherFileRepo = new TeacherFileRepository(filename);
    }

    public void controller_writeObj(ObjectOutputStream objectOutputStream, Teacher entity) throws IOException{
        teacherFileRepo.writeObject(objectOutputStream, entity);
    }

    public void controller_readObj(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        teacherFileRepo.readObject(objectInputStream);
    }


    public void controller_findOne(int id) throws IOException, ClassNotFoundException {
        teacherFileRepo.findOne(id);
    }

    public void controller_findAll() throws IOException, ClassNotFoundException {
        teacherFileRepo.findAll();
    }

    public void controller_save(String nachname, String vorname, int id) throws IOException{
        teacherFileRepo.save(new Teacher(nachname, vorname, id));
    }

    public void controller_Delete(int id) throws IOException{
        Teacher teacherToDelete = null;
        for(Teacher teacher : teacherFileRepo.getRepositoryList()){
            if(teacher.getTeacherID() == id){
                teacherToDelete = new Teacher(teacher.getNachname(), teacher.getVorname(), teacher.getTeacherID());
            }
        }
        teacherFileRepo.delete(teacherToDelete);
    }

    public void controller_update(Teacher entity) throws IOException, ClassNotFoundException {
        teacherFileRepo.update(entity);
    }
}
*/