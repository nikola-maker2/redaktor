package controller;

import model.Cat;
import model.Dog;
import model.SpeakBehavior;
import view.MyFrame;
import view.MyPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Controller {
    Cat cat;
    Dog dog;
    MyPanel myPanel;
    MyFrame myFrame;
    SpeakBehavior startanimal;
    Point2D[] points;
    Rectangle2D rectangle2D;
    Ellipse2D ellipse2D;
    RectangularShape currentShape;
    private boolean isRectangle = true;
    public Controller() {
        rectangle2D = new Rectangle2D.Double();
        ellipse2D = new Ellipse2D.Double();
        currentShape = rectangle2D;
        points = new Point2D[2];
        myPanel = new MyPanel(this);
        myFrame = new MyFrame(myPanel);
    }

    public String catAction() {
        SpeakBehavior cat = new Cat("Myrka");
        return cat.speak();
    }

    public String dogAction() {
        SpeakBehavior dog = new Dog("Bim");
        return dog.speak();
    }

    public void mousePressed(Point point) {
        points[0]= point;
    }
    public void mouseDragged(Point point) {
        points[1]= point;
    }
    public void toggleShape(){
        isRectangle = !isRectangle;
        currentShape = isRectangle?rectangle2D:ellipse2D;
        points[0]=null;
        points[1]=null;
    }


    public void draw(Graphics2D g2) {
        currentShape.setFrameFromDiagonal(points[0],points[1]);
        g2.fill(currentShape);
    }
}