package kenazCode;

import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel {
    Graphics2D graph;

    public Paint(){
        setSize(1200,820);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph = (Graphics2D) g;
    }
}

