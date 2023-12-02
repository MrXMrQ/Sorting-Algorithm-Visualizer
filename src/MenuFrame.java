import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuFrame extends JFrame {
    public MenuFrame(int WIDTH, int HEIGHT, SortingObjects[] sortingObjects) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setTitle("Sorting Menu");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        JButton shuffleButton = new JButton("shuffle");
        shuffleButton.setBounds(0, 0, getWidth(), 50);
        shuffleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Thread(() -> Main.shuffle(sortingObjects)).start();
            }
        });
        add(shuffleButton);

        JButton bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.setBounds(0, shuffleButton.getY() + 60, getWidth(), 50);
        bubbleSortButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.sort = "Bubble";
                new Thread(() -> Main.bubbleSort(sortingObjects)).start();
            }
        });
        add(bubbleSortButton);

        JButton selectionSortButton = new JButton("Selection sort");
        selectionSortButton.setBounds(0, bubbleSortButton.getY() + 60, getWidth(), 50);
        selectionSortButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.sort = "Insertion";
                Main.selectionSort(sortingObjects);

            }
        });
        add(selectionSortButton);

        JButton mergeSortButton = new JButton("Merge sort");
        mergeSortButton.setBounds(0, selectionSortButton.getY() + 60, getWidth(), 50);
        mergeSortButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.sort = "Insertion";
                new Thread(() -> Main.mergeSort(sortingObjects, sortingObjects.length)).start();
                System.out.println("s");
            }
        });
        add(mergeSortButton);

        JButton quickSortButton = new JButton("Quick sort");
        quickSortButton.setBounds(0, mergeSortButton.getY() + 60, getWidth(), 50);
        quickSortButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.sort = "Insertion";
                new Thread(() -> Main.quickSort(sortingObjects)).start();
            }
        });
        add(quickSortButton);

        JButton insertionSortButton = new JButton("Insertion sort");
        insertionSortButton.setBounds(0, quickSortButton.getY() + 60, getWidth(), 50);
        insertionSortButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.sort = "Insertion";
                new Thread(() -> Main.insertionSort(sortingObjects)).start();
            }
        });
        add(insertionSortButton);
    }
}