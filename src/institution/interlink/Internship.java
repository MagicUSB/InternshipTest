package institution.interlink;

import institution.University;
import person.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Internship {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Internship(String name) {
        this.name = name;
    }

    public String getStudents(University university) {
        if (university != null && university.getStudentList()
                .size() > 0) {
            int averageKnowledgeLevel = university.getStudentList()
                    .stream()
                    .reduce(0, (subtotal, element) -> subtotal + element.getKnowledge()
                                    .getKnowledgeLevel(),
                            Integer::sum)
                    / university.getStudentList()
                    .size();
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
