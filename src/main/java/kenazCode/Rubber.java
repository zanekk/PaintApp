package kenazCode;

import java.awt.*;

public class Rubber extends DrawingTool {
    @Override
    public void draw(int firstX, int firstY, int secondX, int secondY, Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        if(isEnabled){
            g2D.setColor(Color.WHITE);
            g2D.setStroke(new BasicStroke(stroke));
            g2D.drawLine(firstX, firstY, secondX, secondY);
        }
    }


}
