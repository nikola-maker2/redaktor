package controller;

import model.Cat;
import model.Dog;
import model.SpeakBehavior;
import view.MyFrame;
import view.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;

public class Controller  {
    Cat cat;
    Dog dog;
    SpeakBehavior animal;
    MyPanel myPanel;
    MyFrame myFrame;
    Point2D[] points;
    public Controller() {
        points = new Point2D[2];
        cat = new Cat ("pushok");
        dog = new Dog("lucky");
        animal = cat;
        myPanel = new MyPanel(this);
        myFrame = new MyFrame(myPanel);
    }
    public String animalSpeak() {
        return animal.speak();
    }
    public void setCat(){
        this.animal = cat;
    }

    public void setDog() {
        this.animal = dog;
    }

    public void mousePressed(Point point) {
        points[0]=point;
    }

    public void mouseDragged(Point point) {
        points[1]=point;
    }
}
