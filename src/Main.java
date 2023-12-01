import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static MyFrame myFrame;
    public static void main(String[] args) {
        Point[] pixel = new Point[10];
        for (int i = 0; i < pixel.length; i++) {
            pixel[i] = new Point((i + 1) * (5 + 10), (480 - i * 3));
        }
        shuffle(pixel);
        System.out.println(Arrays.toString(pixel));
        myFrame = new MyFrame(pixel);
        bubbleSort(pixel);
    }

    public static void bubbleSort(Point[] pixel) {
        for (int i = 0; i < pixel.length - 1; i++) {
            for (int j = 0; j < pixel.length; j++) {
                if(pixel[j].y < pixel[i + 1].y) {
                    Point temp = pixel[i + 1];
                    pixel[i + 1] = pixel[j];
                    pixel [j] = temp;



                    myFrame.update(myFrame.getGraphics());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void shuffle(Point[] pixel) {
        List<Point> pixelList = Arrays.asList(pixel);
        Collections.shuffle(pixelList);
        pixelList.toArray(pixel);
    }
}