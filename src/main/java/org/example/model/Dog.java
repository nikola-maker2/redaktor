package model;

public class Dog implements SpeakBehavior {
    String name;
    public Dog (String name) {
        this.name=name;
    }
    @Override
    public String speak() {
        return "Гав!";
    }
}
