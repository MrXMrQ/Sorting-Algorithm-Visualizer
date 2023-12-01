import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    int width;
    int height;
    int blockWidth;
    int xGap;
    Point[] pixel;

    public MyFrame(int width, int height, int blockWidth, int xGap ,Point[] pixel) {
        this.height = height;
        this.width = width;
        this.blockWidth =  blockWidth;
        this.xGap = xGap;
        this.pixel = pixel;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(width, height));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < pixel.length; i++) {
            g.fillRect((i + 1) * (xGap + blockWidth), pixel[i].y, blockWidth,height - pixel[i].y);
        }
    }
}