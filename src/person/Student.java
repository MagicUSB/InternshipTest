package person;

import main.Application;
import person.consciousness.Knowledge;

public class Student {

    private String name;
    private Knowledge knowledge;

    public Student(String name) {
        this.name = name;
        this.knowledge = new Knowledge(Application.DEFAULT_KNOWLEDGE_LEVEL);
    }

    public Student(String name, Knowledge knowledge) {
        this.name = name;
        this.knowledge = knowledge;
    }

    public Student(String name, int knowledgeLevel) {
        this.name = name;
        this.knowledge = new Knowledge(knowledgeLevel);
    }

    public String getName() {
        return name;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public String toString() {
        return name;
    }
}
