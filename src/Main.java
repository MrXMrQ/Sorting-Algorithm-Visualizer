public class Main {
    static MyFrame sortingVisualizingFrame = new MyFrame(1000, 500);
    static final int OBJECTXGAP = 5;
    static final int OBJECTWIDTH = 10;
    static final int ELEMENTS = (sortingVisualizingFrame.getWidth() / (OBJECTXGAP + OBJECTWIDTH)) - 2;
    static final int OBJECTYGAP = sortingVisualizingFrame.getHeight() / ELEMENTS;
    static SortingObjects[] sortingObjects = new SortingObjects[ELEMENTS];

    public static void main(String[] args) {
        SortingObjects.fill(sortingObjects, OBJECTYGAP, OBJECTWIDTH);
        SortingObjects.shuffle(sortingObjects, OBJECTXGAP, OBJECTWIDTH);
    }
}