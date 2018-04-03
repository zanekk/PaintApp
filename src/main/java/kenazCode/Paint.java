package kenazCode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Paint extends JPanel {
    ArrayList<Pencil> pencilList ;
    ArrayList<Rubber> rubberList ;
    ArrayList<Oval> ovalList ;
    Graphics2D graph;
    public Paint(){
        rubberList = new ArrayList<Rubber>();
        pencilList = new ArrayList<Pencil>();
        ovalList = new ArrayList<Oval>();
        setSize(1200,820);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        graph = (Graphics2D) g;

       for(Pencil pen : pencilList ){
           pen.draw(graph);
       }

        for(Rubber rubber : rubberList ){
            rubber.draw(graph);
        }

       for(Oval oval : ovalList){

           oval.draw(graph);
       }

    }

    public void addPencil(Pencil pencil){
        pencilList.add(pencil);
        repaint();
    }
    public void addRubber(Rubber rubber){
        rubberList.add(rubber);
        repaint();
    }

    public void addOval(Oval oval){
        ovalList.add(oval);
        repaint();
    }




}

