package ch10;

import javax.swing.*;

public class JFrameDemo extends JFrame {
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setTitle("first frame");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setSize(200,150);
        frame1.setVisible(true);
        frame1.setLocation(100,100);
    }
}
