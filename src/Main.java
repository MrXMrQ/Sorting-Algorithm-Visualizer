import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static MyFrame sortingVisualizingFrame = new MyFrame(1000, 500);
    static MenuFrame menuFrame;
    static int OBJECTXGAP = 5;
    static int OBJECTWIDTH = 10;
    static final int ELEMENTS = (sortingVisualizingFrame.getWidth() / (OBJECTXGAP + OBJECTWIDTH)) - 2;
    static int OBJECTYGAP = sortingVisualizingFrame.getHeight() / ELEMENTS;

    public static void main(String[] args) {
        SortingObjects[] sortingObjects = new SortingObjects[ELEMENTS];
        new Thread(() -> fill(sortingObjects)).start();

        menuFrame = new MenuFrame(250, 500, sortingObjects);

        for (int i = 0; i < sortingObjects.length; i++) {
            System.out.println(i + " " + sortingObjects[i]);
        }
    }

    private static void fill(SortingObjects[] sortingObjects) {
        for (int i = 0; i < sortingObjects.length; i++) {
            sortingObjects[i] = new SortingObjects(0, i * OBJECTYGAP, OBJECTWIDTH, sortingVisualizingFrame.getHeight(), Color.LIGHT_GRAY);
        }


        shuffle(sortingObjects);
        sortingVisualizingFrame.add(sortingObjects, OBJECTXGAP, OBJECTWIDTH);
        SwingUtilities.updateComponentTreeUI(sortingVisualizingFrame);
        menuFrame.setVisible(true);
    }

    public static void shuffle(SortingObjects[] sortingObjects) {
        List<SortingObjects> list = Arrays.asList(sortingObjects);
        Collections.shuffle(list);
        list.toArray(sortingObjects);
        sortingVisualizingFrame.add(sortingObjects, OBJECTXGAP, OBJECTWIDTH);
        menuFrame.setVisible(true);
    }
}