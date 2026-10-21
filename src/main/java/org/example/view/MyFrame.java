package view;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    view.MyPanel myPanel;

    public MyFrame(view.MyPanel myPanel) throws HeadlessException {
        this.myPanel = myPanel;
        add(myPanel);
        super.setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
