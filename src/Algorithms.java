import java.awt.*;

public class Algorithms {
    private String sort;
    private long runtime;
    private long startTime;
    private long endTime;
    private int arrayAccesses = 0;
    private int comparisons = 0;
    private final int DURATION = 150;

    public void bubbleSort(SortingObjects[] sortingObjects) {
        sort = "Bubble";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < sortingObjects.length; i++) {
            for (int j = 0; j < sortingObjects.length - 1; j++) {
                System.out.println("i: " + i + ", j: " + j);
                if (sortingObjects[j].y < sortingObjects[j + 1].y) {
                    comparisons++;
                    swapElements(sortingObjects, j + 1, j);
                }
            }
        }
        endTime = System.currentTimeMillis();
        finish(sortingObjects);
    }

    public void selectionSort(SortingObjects[] sortingObjects) {
        sort = "Selection";
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

    private void swapElements(SortingObjects[] sortingObjects, int index, int i) {
        arrayAccesses += 3;
        sortingObjects[i].setBackground(Color.BLUE);
        sortingObjects[index].setBackground(Color.GREEN);

        SortingObjects temp = sortingObjects[i];
        sortingObjects[i] = sortingObjects[index];
        sortingObjects[index] = temp;

        update(sortingObjects);

        try {
            Thread.sleep(DURATION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sortingObjects[i].setBackground(Color.LIGHT_GRAY);
        sortingObjects[index].setBackground(Color.LIGHT_GRAY);
    }

    private void finish(SortingObjects[] sortingObjects) {
        runtime = endTime - startTime;
        update(sortingObjects);
        int initialAnimationDuration = (int) (1000.0 * Math.exp(-0.2 * sortingObjects.length) + 100.0);

        for (int i = 0; i < sortingObjects.length - 1; i++) {
            int animationDuration = initialAnimationDuration / (i + 1);

            sortingObjects[i].setBackground(Color.DARK_GRAY);
            sortingObjects[i + 1].setBackground(Color.DARK_GRAY);

            try {
                Thread.sleep(animationDuration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            sortingObjects[i].setBackground(Color.LIGHT_GRAY);
            sortingObjects[i + 1].setBackground(Color.LIGHT_GRAY);
        }
        runtime = startTime = endTime = arrayAccesses = comparisons = 0;
        Main.menuFrame.setVisible(true);
    }

    private void update(SortingObjects[] sortingObjects) {
        Main.sortingVisualizingFrame.add(sortingObjects, Main.OBJECTXGAP, Main.OBJECTWIDTH);
        Main.sortingVisualizingFrame.setTitle(sort + " sort" + " | array accesses: " + arrayAccesses + " | comparisons: " + comparisons + " | elements: " + sortingObjects.length + " | delay: " + DURATION + " | runtime: " + runtime + "ms");
    }
}
