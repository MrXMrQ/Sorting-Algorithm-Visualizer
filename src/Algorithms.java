import java.awt.*;

public class Algorithms {
    private String sort;
    private long runtime, startTime, endTime;
    private int arrayAccesses, comparisons = 0;
    private final int DURATION = 0;

    public void bubbleSort(SortingObjects[] sortingObjects) {
        sort = "Bubble";
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

    private void swapElements(SortingObjects[] sortingObjects, int swapElement, int baseElement) {
        arrayAccesses += 3;
        sortingObjects[swapElement].setBackground(Color.BLUE);
        sortingObjects[baseElement].setBackground(Color.GREEN);

        SortingObjects temp = sortingObjects[baseElement];
        sortingObjects[baseElement] = sortingObjects[swapElement];
        sortingObjects[swapElement] = temp;

        update(sortingObjects);

        try {
            Thread.sleep(DURATION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sortingObjects[swapElement].setBackground(Color.LIGHT_GRAY);
        sortingObjects[baseElement].setBackground(Color.LIGHT_GRAY);
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
        MyFrame.buttonPanel.setVisible(true);
    }

    private void update(SortingObjects[] sortingObjects) {
        Main.sortingVisualizingFrame.add(sortingObjects, Main.OBJECTXGAP, Main.OBJECTWIDTH);
        Main.sortingVisualizingFrame.setTitle(sort + " sort" + " | array accesses: " + arrayAccesses + " | comparisons: " + comparisons + " | elements: " + sortingObjects.length + " | delay: " + DURATION + " | runtime: " + runtime + "ms");
    }
}
