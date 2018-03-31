package kenazCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Display extends JPanel{
JButton pencil, rectangle, circle, line, rubber;
int firstX , firstY, secondX, secondY;
JFrame frame;
Paint paintingPanel = new Paint();

public Display(){
    frame = new JFrame("PaintApp");
    frame.setSize(1200,800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridBagLayout());

    frame.add(pencil = new JButton("Pencil"));
    frame.add(rectangle = new JButton("Rectangle"));
    frame.add(circle = new JButton("Circle"));
    frame.add(line = new JButton("Line"));
    frame.add(rubber = new JButton("Rubber"));
    frame.add(paintingPanel);
    frame.setVisible(true);
    paintingPanel.setBackground(Color.WHITE);

    frame.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            firstX = e.getX() - 10;
            firstY = e.getY() - 30;

        }
    });
    frame.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            secondX = e.getX() - 10;
            secondY = e.getY() - 30;

            Pencil newLine = new Pencil(firstX,firstY,secondX,secondY);
            paintingPanel.addPencil(newLine);
            firstX = secondX;
            firstY = secondY;
        }
    });


   }



}