package ch10;

import javax.swing.*;

public class MyFirstFrame extends JFrame {
    public MyFirstFrame(String title) {
        super(title);
    }
    public static void main(String[] args) {
        MyFirstFrame frame1 = new MyFirstFrame("my first frame");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setSize(200,150);
        frame1.setVisible(true);
        frame1.setLocation(100,100);
    }
}
