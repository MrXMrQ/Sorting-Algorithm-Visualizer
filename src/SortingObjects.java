import javax.swing.*;
import java.awt.*;

public class SortingObjects extends JPanel {
    int x;
    int y;
    int WIDTH;
    int HEIGHT;
    Color color;

    public SortingObjects(int x, int y, int WIDTH,int HEIGHT, Color color) {
        this.x = x;
        this.y = y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.color = color;

        setBounds(x,y,WIDTH,HEIGHT);
        setBackground(color);
    }
}
