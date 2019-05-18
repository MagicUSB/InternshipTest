package main;

import institution.University;
import institution.interlink.Internship;
import person.Student;
import person.consciousness.Knowledge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Student> getListOfStudentsFromFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String temp;
            List<Student> resultList = new ArrayList<>();
            while ((temp = bufferedReader.readLine()) != null) {
                String split[] = temp.split(" \\* ");
                if (split.length == 1) {
                    resultList.add(new Student(split[0]));
                } else {
                    resultList.add(new Student(split[0], Integer.parseInt(split[1])));
                }
            }
            return resultList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static final int DEFAULT_KNOWLEDGE_LEVEL = 50;

    public static void main(String[] args) {
        University university = new University("CH.U.I.");
        university.addStudent(new Student("Andrew Kostenko"));
        university.addStudent(new Student("Julia Veselkina"));
        university.addStudent(new Student("Maria Perechrest", 60));
        university.addStudent(new Student("Yuliia Mysiura", 70));
        university.addStudent(new Student("Vasya Pupkin", new Knowledge(30)));
        //university.setStudentList(getListOfStudentsFromFile("students.txt"));

        Internship internship = new Internship("Interlink");
        System.out.println("List of internship's students:");
        System.out.println(internship.getStudents(university));
    }
}
