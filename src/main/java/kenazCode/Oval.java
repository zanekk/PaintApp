package kenazCode;

import java.awt.*;

public class Oval extends DrawingTool{
    @Override
    public void drawFigure(int firstX, int firstY, int secondX, int secondY, Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        if(isEnabled){
            g2D.setColor(color);
            g2D.setStroke(new BasicStroke(stroke));
            g2D.drawOval(firstX, firstY, Math.abs(secondX-firstX), Math.abs(secondY-firstY));
        }
    }

}
