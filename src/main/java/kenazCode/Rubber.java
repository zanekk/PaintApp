package kenazCode;

import java.awt.*;

public class Rubber {
    int x1, y1, x2, y2;

    public Rubber(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g){
        Graphics2D graph = (Graphics2D) g;
        graph.drawLine(x1,y1,x2,y2);
        graph.setColor(Color.BLUE);
        graph.setStroke(new BasicStroke(10));
    }


}
