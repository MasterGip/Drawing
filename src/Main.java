import javax.swing.*;

public class Main {

    public static MainFrame myFrame;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myFrame = new MainFrame();
            }
        });
    }
}
