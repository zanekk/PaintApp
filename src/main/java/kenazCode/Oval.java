package kenazCode;

import java.awt.*;

public class Oval {
    int heigth, width ,x ,y ;

    public Oval(int x, int y, int height, int width){
    this.heigth = heigth;
    this.width = width;

    }

    public void draw(Graphics g){
        g.drawOval(x,y,width,heigth);

    }


}
