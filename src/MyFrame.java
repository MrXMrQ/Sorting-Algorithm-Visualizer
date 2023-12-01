import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(int WIDTH, int HEIGHT) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setTitle("Sorting visualizer");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
    }

    public void add(SortingObjects[] sortingObjects) {
        for (int i = 0; i < sortingObjects.length; i++) {
            sortingObjects[i].setLocation((i + 1) * (5 + 10), sortingObjects[i].y);
            this.add(sortingObjects[i]);
        }
    }
}
