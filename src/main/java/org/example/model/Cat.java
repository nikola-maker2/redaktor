package model;

public class Cat implements SpeakBehavior {
    String name;
    public Cat(String name) {
        this.name=name;
    }
    @Override
    public String speak() {
        return "Мяу!";
    }
}
