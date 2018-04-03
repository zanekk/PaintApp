package kenazCode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Display extends JPanel {

    JButton pencil, rectangle, circle, line, rubber;
    JButton[] colorsButtons;
    int firstX, firstY, secondX, secondY;
    Color butColor;
    JFrame frame;
    Paint paintingPanel;
    Box boxLayout;

    public Display() {
        colorsButtons = new JButton[18];
        butColor = new Color(0, 0, 0);
        paintingPanel = new Paint();
        boxLayout = new Box(BoxLayout.X_AXIS);

        frame = new JFrame("PaintApp");
        frame.setSize(1180, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boxLayout.add(pencil = new JButton("Pencil"));
        boxLayout.add(rectangle = new JButton("Rectangle"));
        boxLayout.add(circle = new JButton("Circle"));
        boxLayout.add(line = new JButton("Line"));
        boxLayout.add(rubber = new JButton("Rubber"));

        for (int i = 0; i < 18; i++) {
            colorsButtons[i] = new JButton("" + (i + 1));
            colorsButtons[i].setSize(40, 40);
            boxLayout.add(colorsButtons[i]);
           // colorsButtons[i].addActionListener(this);
        }
        setButtonColor();


        paintingPanel.setBackground(Color.WHITE);
        frame.add(paintingPanel, BorderLayout.CENTER);
        frame.add(boxLayout, BorderLayout.NORTH);
        frame.setVisible(true);


        pencil.addActionListener(e -> {
            frame.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    firstX = e.getX() - 10;
                    firstY = e.getY() - 30;

                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    secondX = e.getX();
                    secondY = e.getY();
                }
            });
            frame.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    secondX = e.getX() - 10;
                    secondY = e.getY() - 30;
                    Pencil newPen = new Pencil(firstX, firstY, secondX, secondY, butColor);
                    paintingPanel.addPencil(newPen);

                    firstX = secondX;
                    firstY = secondY;
                }
            });
        });

        rubber.addActionListener(e -> {
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
                    Rubber newRub = new Rubber(firstX, firstY, secondX, secondY);
                    paintingPanel.addRubber(newRub);

                    firstX = secondX;
                    firstY = secondY;
                }
            });
        });
    }




    public void setButtonColor(){
        colorsButtons[0].setBackground(Color.BLACK);
        colorsButtons[1].setBackground(Color.WHITE);
        colorsButtons[2].setBackground(Color.GRAY);
        colorsButtons[3].setBackground(new Color(255, 255, 0));
        colorsButtons[4].setBackground(new Color(255, 255, 153));
        colorsButtons[5].setBackground(new Color(255, 255, 204));
        colorsButtons[6].setBackground(new Color(255, 204, 204));
        colorsButtons[7].setBackground(new Color(204, 102, 255));
        colorsButtons[8].setBackground(new Color(255, 0, 255));
        colorsButtons[9].setBackground(new Color(255, 102, 0));
        colorsButtons[10].setBackground(new Color(255, 0, 0));
        colorsButtons[11].setBackground(new Color(153, 51, 0));
        colorsButtons[12].setBackground(new Color(204, 204, 0));
        colorsButtons[13].setBackground(new Color(102, 255, 51));
        colorsButtons[14].setBackground(new Color(0, 102, 0));
        colorsButtons[15].setBackground(new Color(0, 204, 153));
        colorsButtons[16].setBackground(new Color(0, 153, 204));
        colorsButtons[17].setBackground(new Color(0, 0, 153));
    }
}