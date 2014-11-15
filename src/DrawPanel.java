import javax.swing.*;
import java.awt.*;

/**
 * Created by mg on 05.11.14.
 */
public class DrawPanel extends JPanel {

    boolean mousePressed;
    int previousX, previousY;


    public void drawPoint(int x, int y){
        Graphics g = this.getGraphics();
        g.fillOval(x, y, 10, 10);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        mousePressed = false;


    }
}
