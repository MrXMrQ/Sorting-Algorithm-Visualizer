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
        Algorithms algorithms = new Algorithms();

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
                new Thread(() -> algorithms.bubbleSort(sortingObjects)).start();
            }
        });
        add(bubbleSortButton);

        JButton selectionSortButton = new JButton("Selection sort");
        selectionSortButton.setBounds(0, bubbleSortButton.getY() + 60, getWidth(), 50);
        selectionSortButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Thread(() -> algorithms.selectionSort(sortingObjects)).start();

            }
        });
        add(selectionSortButton);
    }
}