package kenazCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Display extends JPanel{

    JButton pencilButton, rectangleButton, ovalButton, lineButton, rubberButton;
    JButton[] colorsButtons;
    int firstX, firstY, secondX, secondY,firstXfigure, firstYfigure, secondXfigure, secondYfigure, stroke = 1;
    ArrayList <DrawingTool> drawingList = new ArrayList<DrawingTool>();
    Choice colorChooser;
    Color actualColor;
    JFrame frame;
    Paint paintingPanel;
    Box boxLayout;

    public Display() {
        colorsButtons = new JButton[18];
        paintingPanel = new Paint();
        boxLayout = new Box(BoxLayout.X_AXIS);
        colorChooser = new Choice();


        frame = new JFrame("PaintApp");
        frame.setSize(1180, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonAddingAndPlacing();
        setButtonColors();


        Pencil pencil = new Pencil();
        pencil.setColor(actualColor);
        pencil.setStroke(stroke);
        drawingList.add(pencil);

        Rubber rubber = new Rubber();
        rubber.setStroke(stroke);
        drawingList.add(rubber);

        Line line = new Line();
        line.setColor(actualColor);
        line.setStroke(stroke);
        drawingList.add(line);

        Oval oval= new Oval();
        oval.setColor(actualColor);
        oval.setStroke(stroke);
        drawingList.add(oval);

        Rectangle rect = new Rectangle();
        rect.setColor(actualColor);
        rect.setStroke(stroke);
        drawingList.add(rect);

        paintingPanel.setBackground(Color.WHITE);
        frame.add(paintingPanel, BorderLayout.CENTER);
        frame.add(boxLayout, BorderLayout.NORTH);

        settingColorsButtonsActing();

        pencilButton.addActionListener( e -> {
            enable(drawingList.get(0));
        });
        rubberButton.addActionListener( e -> {
            enable(drawingList.get(1));
        });
        lineButton.addActionListener( e -> {
            enable(drawingList.get(2));
        });
        ovalButton.addActionListener( e -> {
            enable(drawingList.get(3));
        });
        rectangleButton.addActionListener( e -> {
            enable(drawingList.get(4));
        });

       paintingPanel.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (pencil.getEnable() == true || rubber.getEnable() == true) {
                    secondX = e.getX();
                    secondY = e.getY();
                    drawingList.forEach(drawingTool -> {
                        drawingTool.setColor(actualColor);
                        drawingTool.setStroke(stroke);
                        drawingTool.draw(firstX, firstY, secondX, secondY, paintingPanel.getGraphics());
                    });

                    firstX = secondX;
                    firstY = secondY;
                    }

                }


            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                firstX = e.getX();
                firstY = e.getY();

            }
        });

       paintingPanel.addMouseListener(new MouseAdapter() {
             @Override
             public void mousePressed(MouseEvent e) {
                 super.mousePressed(e);
                 stroke = Integer.parseInt(colorChooser.getSelectedItem());
                 firstXfigure = e.getX();
                 firstYfigure = e.getY();

             }

             @Override
             public void mouseReleased(MouseEvent e) {
             super.mouseReleased(e);

                secondXfigure = e.getX();
                secondYfigure = e.getY();
                if(line.getEnable() == true || oval.getEnable() == true || rect.getEnable() == true )
                 drawingList.forEach(drawingTool -> {
                     drawingTool.setColor(actualColor);
                     drawingTool.setStroke(stroke);
                     drawingTool.drawFigure(firstXfigure, firstYfigure, e.getX(), e.getY(), paintingPanel.getGraphics());
                 });
             }
             }

       );

        frame.setVisible(true);
    }


    public void setButtonColors(){
        for(int i = 1 ; i < 18 ; i++)
        colorsButtons[i].setBackground(colorsAssigning(i));
    }

    public void enable(DrawingTool tool){
       drawingList.forEach( drawingTool -> {
           if (drawingTool == tool) drawingTool.setEnable(true);
           else drawingTool.setEnable(false);
       } );
    }

    public void settingColorsButtonsActing(){
        for(int i = 1; i < 18; i ++) {
            Color col = colorsAssigning(i);
            colorsButtons[i].addActionListener(e -> {
                actualColor = col;
            });
        }
    }

    public Color colorsAssigning(int numberOfColor){
        switch (numberOfColor){
            case 1:
                return Color.BLACK;
            case 2:
                return Color.GRAY;
            case 3:
                return new Color(255, 255, 0);
            case 4:
                return new Color(255, 255, 153);
            case 5:
                return new Color(255, 255, 204);
            case 6:
                return new Color(255, 204, 204);
            case 7:
                return new Color(204, 102, 255);
            case 8:
                return new Color(255, 0, 255);
            case 9:
                return new Color(255, 102, 0);
            case 10:
                return new Color(255, 0, 0);
            case 11:
                return new Color(153, 51, 0);
            case 12:
                return new Color(204, 204, 0);
            case 13:
                return new Color(102, 255, 51);
            case 14:
                return new Color(0, 102, 0);
            case 15:
                return new Color(0, 204, 153);
            case 16:
                return new Color(0, 153, 204);
            case 17:
                return new Color(0, 0, 153);
        }
            return null;
    }


    public void buttonAddingAndPlacing(){
        boxLayout.add(pencilButton = new JButton("Pencil"));
        boxLayout.add(rectangleButton = new JButton("Rectangle"));
        boxLayout.add(ovalButton = new JButton("Circle"));
        boxLayout.add(lineButton = new JButton("Line"));
        boxLayout.add(rubberButton = new JButton("Rubber"));

        colorChooser.add("1");
        for(int i = 5; i <= 100 ; i+=5){
        colorChooser.add(""+i);}

        boxLayout.add(colorChooser);
        for (int i = 1; i < 18; i++) {
            colorsButtons[i] = new JButton("" + (i + 1));
            colorsButtons[i].setSize(40, 40);
            boxLayout.add(colorsButtons[i]);
        }
    }

}