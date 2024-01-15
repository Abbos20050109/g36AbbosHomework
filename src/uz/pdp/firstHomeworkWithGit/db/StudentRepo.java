package uz.pdp.firstHomeworkWithGit.db;

import uz.pdp.firstHomeworkWithGit.entity.Student;

import java.util.List;

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
    @Override
    public void save(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void delete(Student student) {

    }
}
