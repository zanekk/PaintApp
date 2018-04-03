package kenazCode;

import java.awt.*;

public class Pencil {
    int x1, y1, x2, y2;
    Color color;

    public Pencil(int x1, int y1, int x2, int y2, Color color){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public void draw(Graphics g){
        g.drawLine(x1,y1,x2,y2);
        g.setColor(color);

    }
}
