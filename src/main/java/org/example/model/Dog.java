package model;

public class Dog implements model.SpeakBehavior {
    private String name;

    public Dog(String Name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String speak() {
        return "Гав";
    }
}
