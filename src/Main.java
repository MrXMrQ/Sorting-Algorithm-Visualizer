import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends JFrame{
    static int ELEMENTS = 65;
    static MyFrame myFrame;
    static Point[] pixel;

    private static final int xGap = 5;
    private static final int yGap = 4;
    private static final int blockWidth = 10;
    private static final int myFrameWidth = 1000;
    private static final int myFrameHeight = 500;
    private static final int myFrameYOffset = 20;
    private static final int duration = 40;

    public static void main(String[] args) {
        pixel = new Point[ELEMENTS];

        for (int i = 0; i < pixel.length; i++) {
            pixel[i] = new Point(0, ((myFrameHeight - myFrameYOffset) - i * yGap));
        }
        pixel = shuffle(pixel);
        myFrame = new MyFrame(myFrameWidth, myFrameHeight, blockWidth, xGap, pixel);
        System.out.println(Arrays.toString(pixel));
        bubbleSort(pixel);

        JButton shuffleButton = new JButton();
        shuffleButton.setBounds(0,0,100,50);
        shuffleButton.setText("shuffle");
        shuffleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pixel = shuffle(pixel);
                myFrame.repaint();
            }
        });
        myFrame.add(shuffleButton);
        myFrame.update(myFrame.getGraphics());
    }

    public static void bubbleSort(Point[] pixel) {
        for (int i = 0; i < pixel.length; i++) {
            for (int j = 0; j < pixel.length - 1; j++) {
                if (pixel[j].y > pixel[j + 1].y) {
                    Point temp = pixel[j + 1];
                    pixel[j + 1] = pixel[j];
                    pixel[j] = temp;
                }
                try {
                    Thread.sleep(duration);
                    myFrame.update(myFrame.getGraphics());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static Point[] shuffle(Point[] pixel) {
        List<Point> pixelList = Arrays.asList(pixel);
        Collections.shuffle(pixelList);
        return pixelList.toArray(pixel);
    }
}