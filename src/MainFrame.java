import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by mg on 05.11.14.
 */
public class MainFrame extends JFrame {

    MainFrameView view;

    public class MainFrameView{
        JLabel lbl_figure;
        DrawPanel pnl_panel;
    }

    public MainFrame(){
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.view = new MainFrameView();
        this.view.lbl_figure = new JLabel("!");
        this.view.pnl_panel = new DrawPanel();
//        this.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                Main.myFrame.view.lbl_figure.setText("!" + e.getX() + " " + e.getY());
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                Main.myFrame.view.lbl_figure.setText(e.getX() + " " + e.getY());
//            }
//        });
        this.view.pnl_panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
//                while(e.) {
                Main.myFrame.view.pnl_panel.mousePressed = true;
                Main.myFrame.view.pnl_panel.drawPoint(e.getX(), e.getY());
                Main.myFrame.view.pnl_panel.previousX = e.getX();
                Main.myFrame.view.pnl_panel.previousY = e.getY();
//                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Main.myFrame.view.pnl_panel.mousePressed = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.view.pnl_panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(Main.myFrame.view.pnl_panel.mousePressed){
                    Main.myFrame.view.pnl_panel.drawPoint(e.getX(), e.getY());
                }
                Main.myFrame.view.lbl_figure.setText(e.getX() + " " + e.getY());
                System.out.println((e.getX() - Main.myFrame.view.pnl_panel.previousX) + " " + (e.getY() - Main.myFrame.view.pnl_panel.previousY ));
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if(Main.myFrame.view.pnl_panel.mousePressed){
                    Main.myFrame.view.pnl_panel.drawPoint(e.getX(), e.getY());
                }
                Main.myFrame.view.lbl_figure.setText("!");
            }
        });
        this.add(view.lbl_figure, BorderLayout.NORTH);
        this.add(view.pnl_panel, BorderLayout.CENTER);
        this.setVisible(true);

    }
}
