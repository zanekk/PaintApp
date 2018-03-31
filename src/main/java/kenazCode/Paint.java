package kenazCode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Paint extends JPanel {
    ArrayList<Pencil> pencilList = new ArrayList<Pencil>();
    ArrayList<Oval> ovalList = new ArrayList<Oval>();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graph = (Graphics2D) g;

       for(Pencil pen : pencilList ){
           pen.draw(graph);
       }

       for(Oval oval : ovalList){

           oval.draw(graph);
       }

    }

    public void addPencil(Pencil pencil){
        pencilList.add(pencil);
        repaint();
    }

    public void addOval(Oval oval){
        ovalList.add(oval);
        repaint();
    }



}

