package kenazCode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Display extends JPanel{

    JButton pencilButton, rectangleButton, circleButton, lineButton, rubberButton;
    JButton[] colorsButtons;
    int firstX, firstY, secondX, secondY;
    ArrayList <DrawingTool> drawingList = new ArrayList<DrawingTool>();
    Color actualColor = Color.BLACK;
    JFrame frame;
    Paint paintingPanel;
    Box boxLayout;

    public Display() {
        colorsButtons = new JButton[18];
        paintingPanel = new Paint();
        boxLayout = new Box(BoxLayout.X_AXIS);

        frame = new JFrame("PaintApp");
        frame.setSize(1180, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPlacing();
        setButtonColors();

        Pencil pencil = new Pencil();
        pencil.setColor(actualColor);
        drawingList.add(pencil);

        paintingPanel.setBackground(Color.WHITE);
        frame.add(paintingPanel, BorderLayout.CENTER);
        frame.add(boxLayout, BorderLayout.NORTH);

        pencilButton.addActionListener( e -> {
            enable(drawingList.get(0));
        });

        paintingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                secondX = e.getX() - 10;
                secondY = e.getY() - 30;
                drawingList.forEach(drawingTool -> {
                    drawingTool.draw(firstX, firstY, secondX, secondY, frame.getGraphics());
                });

                firstX = secondX;
                firstY = secondY;
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                super.mouseMoved(mouseEvent);
                firstX = mouseEvent.getX() - 10;
                firstY = mouseEvent.getY() - 30;
            }
        });
        frame.setVisible(true);
    }


    public void setButtonColors(){
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

    public void enable(DrawingTool tool){
       drawingList.forEach( drawingTool -> {
           if (drawingTool == tool) drawingTool.setEnable(true);
           else drawingTool.setEnable(false);
       } );
    }


    public void buttonPlacing(){
        boxLayout.add(pencilButton = new JButton("Pencil"));
        boxLayout.add(rectangleButton = new JButton("Rectangle"));
        boxLayout.add(circleButton = new JButton("Circle"));
        boxLayout.add(lineButton = new JButton("Line"));
        boxLayout.add(rubberButton = new JButton("Rubber"));

        for (int i = 0; i < 18; i++) {
            colorsButtons[i] = new JButton("" + (i + 1));
            colorsButtons[i].setSize(40, 40);
            boxLayout.add(colorsButtons[i]);
        }
    }

}