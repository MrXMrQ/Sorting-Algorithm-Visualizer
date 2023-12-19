import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {
    public static JPanel buttonPanel;

    public MyFrame(int WIDTH, int HEIGHT) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Sorting visualizer");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(0, this.getHeight() - this.getHeight() / 6, this.getWidth(), this.getHeight() / 6 - 35);
        buttonPanel.setBackground(new Color(0,0,0,100));
        buttonPanel.setLayout(null);
        // Subtracting 35 due to the Y offset of the frame and dividing by 4 because we always want to maintain the panel in a 4:1 ratio to the frame.

        Algorithms algorithms = new Algorithms();
        int BUTTONXGAP = 20;
        int BUTTONNUMBER = 10;
        int BUTTONWIDTH = (buttonPanel.getWidth() - BUTTONXGAP) / BUTTONNUMBER;
        int BUTTONHEIGHT = buttonPanel.getHeight() / 2;
        int BUTTONYGAP = buttonPanel.getHeight() / 2 - BUTTONHEIGHT / 2;

        JButton shuffleButton = new JButton("shuffle");
        shuffleButton.setBounds(0, BUTTONYGAP, BUTTONWIDTH, BUTTONHEIGHT);
        shuffleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> SortingObjects.shuffle(Main.sortingObjects, Main.OBJECTXGAP, Main.OBJECTWIDTH)).start();
            }
        });
        buttonPanel.add(shuffleButton);

        JButton bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.setBounds(shuffleButton.getX() + shuffleButton.getWidth() + BUTTONXGAP, BUTTONYGAP, BUTTONWIDTH, BUTTONHEIGHT);
        bubbleSortButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setVisible(false);
                new Thread(() -> algorithms.bubbleSort(Main.sortingObjects)).start();
            }
        });
        buttonPanel.add(bubbleSortButton);

        JButton selectionSortButton = new JButton("Selection sort");
        selectionSortButton.setBounds(bubbleSortButton.getX() + bubbleSortButton.getWidth() + BUTTONXGAP, BUTTONYGAP, BUTTONWIDTH, BUTTONHEIGHT);
        selectionSortButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setVisible(false);
                new Thread(() -> algorithms.selectionSort(Main.sortingObjects)).start();
            }
        });
        buttonPanel.add(selectionSortButton);

        add(buttonPanel);
    }

    public void add(SortingObjects[] sortingObjects, int OBJECTXGAP, int OBJECTWIDTH) {
        for (int i = 0; i < sortingObjects.length; i++) {
            sortingObjects[i].setLocation((i + 1) * (OBJECTXGAP + OBJECTWIDTH), sortingObjects[i].y);
            this.add(sortingObjects[i]);
        }
        SwingUtilities.updateComponentTreeUI(Main.sortingVisualizingFrame);
    }
}
