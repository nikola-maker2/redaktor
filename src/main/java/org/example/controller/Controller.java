package org.example.controller;

import org.example.model.Cat;
import org.example.model.Dog;
import org.example.model.SpeakBehavior;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Cat cat;
    Dog dog;
    MyPanel myPanel;
    MyFrame myFrame;
    Point2D[] points;

    private final Rectangle2D rectangle2D;
    private final Ellipse2D ellipse2D;

    @FunctionalInterface
    private interface DrawStrategy {
        void execute(Graphics2D g2, RectangularShape shape);
    }


    private static class RenderMode {
        final RectangularShape shape;
        final DrawStrategy strategy;

        RenderMode(RectangularShape shape, DrawStrategy strategy) {
            this.shape = shape;
            this.strategy = strategy;
        }
    }


    private static class HistoryItem {
        final RectangularShape shapeCopy;
        final DrawStrategy strategy;

        HistoryItem(RectangularShape shape, DrawStrategy strategy) {

            this.shapeCopy = (RectangularShape) shape.clone();
            this.strategy = strategy;
        }

        void draw(Graphics2D g2) {
            strategy.execute(g2, shapeCopy);
        }
    }

    private final RenderMode[] renderModes;
    private int currentModeIndex = 0;


    private final List<HistoryItem> history = new ArrayList<>();

    public Controller() {
        rectangle2D = new Rectangle2D.Double();
        ellipse2D = new Ellipse2D.Double();
        points = new Point2D[2];

        renderModes = new RenderMode[] {
                new RenderMode(rectangle2D, (g2, shape) -> g2.draw(shape)),
                new RenderMode(rectangle2D, (g2, shape) -> g2.fill(shape)),
                new RenderMode(ellipse2D,   (g2, shape) -> g2.draw(shape)),
                new RenderMode(ellipse2D,   (g2, shape) -> g2.fill(shape))
        };

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
        points[0] = point;
        points[1] = point;
    }

    public void mouseDragged(Point point) {
        points[1] = point;
    }

    public void toggleShape() {
        currentModeIndex = (currentModeIndex + 1) % renderModes.length;
        points[0] = null;
        points[1] = null;
    }


    public void addCurrentShapeToList() {
        if (points[0] != null && points[1] != null) {
            RenderMode currentMode = renderModes[currentModeIndex];
            currentMode.shape.setFrameFromDiagonal(points[0], points[1]);


            history.add(new HistoryItem(currentMode.shape, currentMode.strategy));


            points[0] = null;
            points[1] = null;
        }
    }


    public void clearHistory() {
        history.clear();
        points[0] = null;
        points[1] = null;
    }


    public void draw(Graphics2D g2) {

        for (HistoryItem item : history) {
            item.draw(g2);
        }


        if (points[0] != null && points[1] != null) {
            RenderMode currentMode = renderModes[currentModeIndex];
            currentMode.shape.setFrameFromDiagonal(points[0], points[1]);
            currentMode.strategy.execute(g2, currentMode.shape);
        }
    }
}