package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {
    JTextField t1;
    JTextField t2;
    JButton button;
    JButton dogbutton;
    JButton switchButton;

    Controller controller;


    public MyPanel(Controller controller) {
        this.controller = controller;

        t1 = new JTextField("", 10);
        t2 = new JTextField("", 10);
        button = new JButton("Action 1");
        dogbutton = new JButton("Action 2");
        switchButton = new JButton("Perecluchit");
        add(t1);
        add(t2);
        add(button);
        add(dogbutton);
        this.setBackground(Color.LIGHT_GRAY);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                controller.mousePressed(e.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                controller.mouseDragged(e.getPoint());
                repaint();
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText(controller.catAction());
                t2.setText("Cat");
            }
        });
        dogbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText(controller.dogAction());
                t2.setText("Dog");
            }
        });
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.toggleShape();
                repaint();
            }
        });
        this.add(switchButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        controller.draw(g2);
    }
}