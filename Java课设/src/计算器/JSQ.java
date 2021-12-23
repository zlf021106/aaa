package 计算器;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSQ  extends JFrame implements ActionListener {
    private JPanel jp_north = new JPanel();
    private JTextField input_text = new JTextField();
    private JButton c_Btn = new JButton("C");
    public int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
    public int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
    public int fw = 300;
    public int fh = 300;
    public int frame_x = (sw-fw)/2;
    public int frame_y = (sh-fh)/2;

    private JPanel jp_center = new JPanel();

    public JSQ() throws HeadlessException {
        this.init();
        this.addNorth();
        this.addCenter();

    }

    public void init() { //初始化方法
        this.setTitle("简易计算器");
        this.setSize(fw,fh);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(frame_x,frame_y);
        this.setVisible(true);
    }

    public void addNorth() { //北面控件
        jp_north.add(input_text);
        jp_north.add(c_Btn);
        c_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input_text.setText("");
            }
        });
        this.add(jp_north,BorderLayout.NORTH);
        this.input_text.setPreferredSize(new Dimension(230,30));
    }

    public void addCenter() { //中间控件
        String[] a = {"1","2","3","+","4","5","6","-","7","8","9","*","0",".","=","/"};
        this.jp_center.setLayout(new GridLayout(4,4));
        for(int i =0;i<16;i++) {
            JButton btn = new JButton();
            btn.setText(a[i]);
            btn.addActionListener(this);
            jp_center.add(btn);
        }
        this.add(jp_center,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JSQ jsq = new JSQ();
    }
    private String fuhao = null;
    private String firstInput = null;
    @Override
    public void actionPerformed(ActionEvent e) {
        String clickStr = e.getActionCommand();
        if(".0123456789".indexOf(clickStr)!=-1) {
            this.input_text.setText(input_text.getText()+clickStr);
            this.input_text.setHorizontalAlignment(JTextField.RIGHT);
        }else if(clickStr.matches("[\\+\\-*/]{1}")) {  //{1}是单循环，\\转义字符
            fuhao = clickStr;
            firstInput = this.input_text.getText();
            this.input_text.setText("");
        }else if(clickStr.equals("=")) {
            Double a = Double.valueOf(firstInput);
            Double b = Double.valueOf(this.input_text.getText());
            if(this.input_text == null) {
                b = 0.0;
            }
            Double result = null;
            switch (fuhao) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if(b != 0) {
                        result = a / b;
                    }else{
                        JOptionPane.showMessageDialog(this, "除数不能为0!");
                    }

                    break;
            }
            this.input_text.setText(result.toString());
        }
    }
}
