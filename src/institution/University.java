package institution;

import person.Student;

import java.util.ArrayList;
import java.util.List;

public class University {

    public String getName() {
        return name;
    }

    private String name;
    private List<Student> studentList;

    public University(String name) {
        this.name = name;
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
