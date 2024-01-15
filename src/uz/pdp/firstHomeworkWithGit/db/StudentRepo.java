package uz.pdp.firstHomeworkWithGit.db;

import uz.pdp.firstHomeworkWithGit.entity.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepo implements Repository<Student> {
    private static final String PATH="src/uz/pdp/firstHomeworkWithGit/db/data_base.txt";
    private List<Student> students;
    private static StudentRepo singleton;
    private StudentRepo(List<Student> users) {
        this.students=users;
    }
    public static StudentRepo getInstance(){
        if (singleton==null){
            singleton=new StudentRepo(loadData());
        }
        return singleton;
    }
    @SuppressWarnings("unchecked")
    private static List<Student> loadData() {

        try(InputStream inputStream=new FileInputStream(PATH);
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
        ) {
            return (List<Student>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void update(Student student) {
        student.setAge(10);
        student.setName("ab");
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(Student student) {

    }
}
