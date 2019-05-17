package institution.interlink;

import institution.University;
import person.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Internship {

    private String name;

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private University university;

    public Internship(String name) {
        this.name = name;
    }

    public void setStudent(Student student) {
        //TODO: Implementation is needed
    }

    public String getStudents() {
        if (university != null) {
            int averageKnowledgeLevel = university.getStudentList()
                    .stream()
                    .reduce(0, (subtotal, element) -> subtotal + element.getKnowledge()
                                    .getKnowledgeLevel(),
                            Integer::sum)
                    / university.getStudentList().size();
            List<Student> studentList = university.getStudentList()
                    .stream()
                    .filter(x -> x.getKnowledge()
                            .getKnowledgeLevel()
                            >= averageKnowledgeLevel)
                    .sorted(Comparator.comparing(Student::getName))
                    .collect(Collectors.toList());
            StringBuilder result = new StringBuilder();
            for (Student student : studentList) {
                result.append(student)
                        .append("\n");
            }
            return result.toString();
        }
        return "";
    }
}
