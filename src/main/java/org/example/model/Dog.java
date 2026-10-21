package org.example.model;

import org.example.model.SpeakBehavior;

public class Dog implements SpeakBehavior {
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
