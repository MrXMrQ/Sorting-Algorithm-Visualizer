import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingObjects extends JPanel {
    public int y;

    public SortingObjects(int x, int y, int WIDTH, int HEIGHT, Color color) {
        this.y = y;

        setBounds(x, y, WIDTH, HEIGHT);
        setBackground(color);
    }

    public static void fill(SortingObjects[] sortingObjects, int OBJECTYGAP, int OBJECTWIDTH) {
        for (int i = 0; i < sortingObjects.length; i++) {
            sortingObjects[i] = new SortingObjects(0, i * OBJECTYGAP, OBJECTWIDTH, Main.sortingVisualizingFrame.getHeight(), Color.LIGHT_GRAY);
        }
    }

    public static void shuffle(SortingObjects[] sortingObjects, int OBJECTXGAP, int OBJECTWIDTH) {
        List<SortingObjects> list = Arrays.asList(sortingObjects);
        Collections.shuffle(list);
        list.toArray(sortingObjects);
        Main.sortingVisualizingFrame.add(sortingObjects, OBJECTXGAP, OBJECTWIDTH);
    }
}
