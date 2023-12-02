import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    static MyFrame sortingVisualizingFrame = new MyFrame(1000, 500);
    static MenuFrame menuFrame;
    static int animationDuration = 20;

    static int OBJECTXGAP = 5;
    static int OBJECTWIDTH = 10;

    static int arrayAccesses = 0;
    static int comparisons = 0;
    static final int ELEMENTS = (sortingVisualizingFrame.getWidth() / (OBJECTXGAP + OBJECTWIDTH)) - 2;
    static final int DURATION = 0;
    static long startTime;
    static long endTime;
    static long runtime;

    static boolean shuffle = true;
    static int OBJECTYGAP = sortingVisualizingFrame.getHeight() / ELEMENTS;

    public static void main(String[] args) {
        sortingVisualizingFrame.setTitle("array accesses: " + arrayAccesses + ", comparisons: " + comparisons + ", elements: " + ELEMENTS + ", sleep time: " + DURATION + ", Runtime: " + runtime + " mil");

        SortingObjects[] sortingObjects = new SortingObjects[ELEMENTS];
        new Thread(() -> fill(sortingObjects)).start();

        menuFrame = new MenuFrame(250, 500, sortingObjects);
        menuFrame.setVisible(false);
    }

    public static void fill(SortingObjects[] sortingObjects) {
        for (int i = 0; i < sortingObjects.length; i++) {
            sortingObjects[i] = new SortingObjects(0, i * OBJECTYGAP, OBJECTWIDTH, sortingVisualizingFrame.getHeight(), Color.LIGHT_GRAY);
        }

        shuffle(sortingObjects);
        sortingVisualizingFrame.add(sortingObjects, OBJECTXGAP, OBJECTWIDTH);
        SwingUtilities.updateComponentTreeUI(sortingVisualizingFrame);
        menuFrame.setVisible(true);
    }

    public static void shuffle(SortingObjects[] sortingObjects) {
        Random rand = new Random();
        for (int i = 0; i < sortingObjects.length; i++) {
            int index = rand.nextInt(i + 1);
            swapElements(sortingObjects, index, i);
        }

        SwingUtilities.updateComponentTreeUI(sortingVisualizingFrame);
        finish(sortingObjects);
    }

    public static void swapElements(SortingObjects[] sortingObjects, int index, int i) {
        arrayAccesses += 3;
        sortingObjects[i].setBackground(Color.BLUE);
        sortingObjects[index].setBackground(Color.GREEN);

        SortingObjects temp = sortingObjects[i];
        sortingObjects[i] = sortingObjects[index];
        sortingObjects[index] = temp;

        sortingVisualizingFrame.add(sortingObjects, OBJECTXGAP, OBJECTWIDTH);
        sortingVisualizingFrame.setTitle("array accesses: " + arrayAccesses + ", comparisons: " + comparisons + ", elements: " + ELEMENTS + ", sleep time: " + DURATION + ", Runtime: " + runtime + " mil");

        if (DURATION > 0 && !shuffle) {
            try {
                Thread.sleep(DURATION);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        sortingObjects[i].setBackground(Color.LIGHT_GRAY);
        sortingObjects[index].setBackground(Color.LIGHT_GRAY);
    }

    public static void finish(SortingObjects[] sortingObjects) {
        runtime = (endTime - startTime);

        for (int i = 0; i < sortingObjects.length - 1; i++) {
            sortingObjects[i].setBackground(Color.DARK_GRAY);
            sortingObjects[i + 1].setBackground(Color.DARK_GRAY);

            SwingUtilities.updateComponentTreeUI(sortingVisualizingFrame);

            try {
                Thread.sleep(animationDuration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            sortingObjects[i].setBackground(Color.LIGHT_GRAY);
            sortingObjects[i + 1].setBackground(Color.LIGHT_GRAY);

            if (animationDuration > 3) {
                animationDuration--;
            }
        }
        arrayAccesses = 0;
        comparisons = 0;
        startTime = 0;
        endTime = 0;
        runtime = 0;
        animationDuration = 20;
        menuFrame.setVisible(true);
    }

    public static void bubbleSort(SortingObjects[] sortingObjects) {
        sortingVisualizingFrame.setTitle("array accesses: " + arrayAccesses + ", comparisons: " + comparisons + ", elements: " + ELEMENTS + ", sleep time: " + DURATION + ", Runtime: " + runtime + " mil");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < sortingObjects.length; i++) {
            for (int j = 0; j < sortingObjects.length - 1; j++) {
                if (sortingObjects[j].y < sortingObjects[j + 1].y) {
                    comparisons++;
                    swapElements(sortingObjects, j + 1, j);
                }
            }
        }
        endTime = System.currentTimeMillis();
        finish(sortingObjects);
    }

    public static void selectionSort(SortingObjects[] sortingObjects) {
        sortingVisualizingFrame.setTitle("array accesses: " + arrayAccesses + ", comparisons: " + comparisons + ", elements: " + ELEMENTS + ", sleep time: " + DURATION + ", Runtime: " + runtime + " mil");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < sortingObjects.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortingObjects.length; j++) {
                if (sortingObjects[j].getY() > sortingObjects[minIndex].getY()) {
                    comparisons++;
                    minIndex = j;
                }
            }
            swapElements(sortingObjects, minIndex, i);
        }
        endTime = System.currentTimeMillis();
        finish(sortingObjects);
    }

    public static void mergeSort(SortingObjects[] sortingObjects) {

    }

    public static void quickSort(SortingObjects[] sortingObjects) {

    }

    public static void insertionSort() {

    }

    public static void slowSort() {

    }
}