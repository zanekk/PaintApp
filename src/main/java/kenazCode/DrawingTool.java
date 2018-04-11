package kenazCode;

import java.awt.*;

public abstract class DrawingTool
{
    Color color ;
    boolean isEnabled = false;
    int stroke;

    public void draw(int firstX, int firstY, int secondX, int secondY, Graphics g) {
        if(isEnabled){
            g.setColor(color);
            g.drawLine(firstX, firstY, secondX, secondY);
        }
    }

    public void drawFigure(int firstX, int firstY, int secondX, int secondY, Graphics g) {
        if(isEnabled){
            g.setColor(color);
            g.drawLine(firstX, firstY, secondX, secondY);
        }
    }

    public void setStroke(int strokeNumber){
        this.stroke = strokeNumber;
    }

    public void setColor(Color color) {
     this.color = color;
    }

    public void setEnable(boolean enable){
        this.isEnabled = enable;
    }

    public boolean getEnable(){
        return isEnabled;
    }
}
