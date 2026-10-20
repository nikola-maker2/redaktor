package view;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyPanel myPanel;
    public MyFrame(MyPanel myPanel) throws HeadlessException {
        this.myPanel = myPanel;
        add(myPanel);
        super.setSize(500,500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
}
