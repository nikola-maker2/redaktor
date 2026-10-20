package view;

import controller.Controller;
import model.Cat;
import model.Dog;
import model.SpeakBehavior;

import javax.swing. *;
import java.awt. *;
import java.awt.event.*;

public class MyPanel extends JPanel {
    JTextField t1;
    JTextField t2;
    JButton button;
    JButton b2;
    JButton cat;
    JButton dog;
    Controller controller;

    public MyPanel(Controller controller) {
        this.controller = controller;
        t1 = new JTextField("                   ");
        t2 = new JTextField("                   ");
        button = new JButton("button");
        b2 = new JButton("speak");
        cat = new JButton("switchCat");
        dog = new JButton("switchDog");

        add(t1);
        add(t2);
        add(button);
        add(b2);
        add(cat);
        add(dog);
        button.addActionListener(e -> t2.setText(t1.getText().trim()));
        b2.addActionListener(e -> t1.setText(controller.animalSpeak()));
        cat.addActionListener(e -> controller.setCat());
        dog.addActionListener(e -> controller.setDog());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                controller.mousePressed(e.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
             controller.mouseDragged(e.getPoint());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }
}
