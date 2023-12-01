import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    Point[] pixel;
    public MyFrame(Point[] pixel) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 500));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        this.pixel = pixel;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < pixel.length; i++) {
            g.fillRect((i + 1) * (5 + 10), pixel[i].y, 10,this.getHeight() + 500);
        }
    }
}