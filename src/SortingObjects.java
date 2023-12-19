import javax.swing.*;
import java.awt.*;

public class SortingObjects extends JPanel {
    private int x;
    public int y;
    private int WIDTH;
    private int HEIGHT;
    private Color color;

    public SortingObjects(int x, int y, int WIDTH, int HEIGHT, Color color) {
        this.x = x;
        this.y = y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.color = color;

        setBounds(x, y, WIDTH, HEIGHT);
        setBackground(color);
    }
}
