package main;

import institution.University;
import institution.interlink.Internship;
import person.Student;
import person.consciousness.Knowledge;

public class Application {

    public static final int DEFAULT_KNOWLEDGE_LEVEL = 50;

    public static void main(String[] args) {
        University university = new University("CH.U.I.");
        university.addStudent(new Student("Andrew Kostenko"));
        university.addStudent(new Student("Julia Veselkina"));
        university.addStudent(new Student("Maria Perechrest", 60));
        university.addStudent(new Student("Yuliia Mysiura", 70));
        university.addStudent(new Student("Vasya Pupkin", new Knowledge(30)));

        Internship internship = new Internship("Interlink");
        System.out.println("List of internship's students:");
        System.out.println(internship.getStudents(university));
    }
}
