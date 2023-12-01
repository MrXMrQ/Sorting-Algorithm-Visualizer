import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Main {
    static MyFrame sortingVisualizingFrame;
    static MyFrame menuFrame;
    static final int ELEMENTS = 64;
    static final int DURATION = 0;
    static int arrayAccesses = 0;
    static int comparisons = 0;
    static long startTime = 0;
    static long endTime = 0;
    static long runtime = 0;

    public static void main(String[] args) {
        sortingVisualizingFrame = new MyFrame(1000,500);
        menuFrame = new MyFrame(250,500);
        sortingVisualizingFrame.setTitle("array accesses: " + arrayAccesses + ", comparisons: " + comparisons + ", elements: " + ELEMENTS + ", sleep time: " + DURATION + ", Runtime: " + runtime + "sec");

        SortingObjects[] sortingObjects = new SortingObjects[ELEMENTS];
        for (int i = 0; i < sortingObjects.length; i++) {
            sortingObjects[i] = new SortingObjects(0, i * 7, 10, sortingVisualizingFrame.getHeight(), Color.LIGHT_GRAY);
        }

        shuffle(sortingObjects);
        sortingVisualizingFrame.add(sortingObjects);
        SwingUtilities.updateComponentTreeUI(sortingVisualizingFrame);

        JButton shuffle = new JButton("shuffle");
        shuffle.setBounds(5,0,130,50);
        shuffle.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> shuffle(sortingObjects)).start();
            }
        });
        menuFrame.add(shuffle);

        JButton bubbleSort = new JButton("Bubble Sort");
        bubbleSort.setBounds(5,60,130,50);
        bubbleSort.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                new Thread(() -> bubbleSort(sortingObjects)).start();
            }
        });
        menuFrame.add(bubbleSort);
    }

    public static void shuffle(SortingObjects[] sortingObjects) {
        Random rand = new Random();
        for (int i = sortingObjects.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);

            SortingObjects temp = sortingObjects[i];
            sortingObjects[i] = sortingObjects[index];
            sortingObjects[index] = temp;
        }
        sortingVisualizingFrame.add(sortingObjects);
        arrayAccesses = 0;
        comparisons = 0;
        startTime = 0;
        endTime = 0;
        runtime = 0;
    }

    public static void finish(SortingObjects[] sortingObjects) {
        for (int i = 0; i < sortingObjects.length - 1; i++) {
            sortingObjects[i].setBackground(Color.DARK_GRAY);
            sortingObjects[i + 1].setBackground(Color.DARK_GRAY);
            SwingUtilities.updateComponentTreeUI(sortingVisualizingFrame);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sortingObjects[i].setBackground(Color.LIGHT_GRAY);
            sortingObjects[i + 1].setBackground(Color.LIGHT_GRAY);
        }
        menuFrame.setVisible(true);
    }

    public static void bubbleSort(SortingObjects[] sortingObjects) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < sortingObjects.length; i++) {
            for (int j = 0; j < sortingObjects.length - 1; j++) {
                if (sortingObjects[j].y < sortingObjects[j + 1].y) {
                    comparisons++;
                    arrayAccesses += 3;

                    sortingObjects[j].setBackground(Color.BLUE);
                    sortingObjects[j + 1].setBackground(Color.GREEN);

                    SortingObjects temp = sortingObjects[j + 1];
                    sortingObjects[j + 1] = sortingObjects[j];
                    sortingObjects[j] = temp;

                    sortingVisualizingFrame.add(sortingObjects);
                    sortingVisualizingFrame.setTitle("array accesses: " + arrayAccesses + ", comparisons: " + comparisons + ", elements: " + ELEMENTS + ", sleep time: " + DURATION + ", Runtime: " + runtime + "sec");
                    SwingUtilities.updateComponentTreeUI(sortingVisualizingFrame);

                    sortingObjects[j].setBackground(Color.LIGHT_GRAY);
                    sortingObjects[j + 1].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
        endTime = System.currentTimeMillis();

        runtime = (endTime - startTime) / 1000;
        sortingVisualizingFrame.setTitle("array accesses: " + arrayAccesses + ", comparisons: " + comparisons + ", elements: " + ELEMENTS + ", sleep time: " + DURATION + ", Runtime: " + runtime + "sec");
        finish(sortingObjects);
    }
}