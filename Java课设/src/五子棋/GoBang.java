package 五子棋;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GoBang extends JFrame implements ActionListener {
    final int temp = 600 / 18;
    int width, height, boardWidth, boardHeight, xbase, ybase;
    int allChess[][] = new int[19][19];
    boolean isBlack = true;
    int x, y;//  这里进行画图时候圆的位置（1,2）在第一行第二列
    int countx = 0, county = 0; // 为了实现认输的位置
    int chessX[] = new int[255];//存储棋盘位置，方便回溯
    int chessY[] = new int[255];
    boolean canPlay = true; // 能不能继续玩

    // 三个面板分别放消息提示框，主面板，一些按钮
    public JPanel jpMessage = new JPanel();
    public JPanel jpMain = new PaintBoard();
    public JPanel jpButton = new JPanel();
    public JLabel jbMessage = new JLabel("黑方下子");

    JButton restart = new JButton("重新开始");
    JButton exit = new JButton("退出游戏");
    JButton fail = new JButton("认输");
    JButton regret = new JButton("悔棋");
    JButton reply = new JButton("复盘");
    public GoBang() {
        this.add(jpMain, BorderLayout.CENTER);
        this.add(jpMessage, BorderLayout.NORTH);
        jpMessage.add(jbMessage);
        // 按钮区的绘制
        restart.addActionListener(this);
        exit.addActionListener(this);
        fail.addActionListener(this);
        regret.addActionListener(this);
        reply.addActionListener(this);

        jpButton.add(restart);
        jpButton.add(exit);
        jpButton.add(fail);
        jpButton.add(regret);
        jpButton.add(reply);
        this.add(jpButton, BorderLayout.SOUTH);
        this.setBounds(0, 0, 700, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        GoBang go = new GoBang();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 重新开始所有清零
        if (e.getSource() == restart) {
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 18; j++) {
                    allChess[i][j] = 0;
                }
            }
            this.repaint();
            isBlack = true;
            jbMessage.setText("黑方下子");
            for (int i = 0; i < 19; i++) {
                chessX[i] = chessY[i] = 0;
            }
            canPlay = true;
        }
        if (e.getSource() == exit) {
            System.exit(0);
        }
        if (e.getSource() == fail) {
            JOptionPane.showMessageDialog(this, (isBlack ? "黑子认输" : "白子认输") + ",游戏结束！");
            canPlay = false;
        }
        if (e.getSource() == regret) {
            if (canPlay) {
                int result = JOptionPane.showConfirmDialog(this, isBlack ? "白方悔棋，是否同意" : "黑方悔棋，是否同意");
                // 棋子回退一次，储存棋子横纵坐标的数组也回退,black也要回退
                if (result == 0) {
                    allChess[chessX[--countx]][chessY[--county]] = 0;
                    if (isBlack) {
                        isBlack = false;
                        jbMessage.setText("白方下子");
                    }else {
                        isBlack = true;
                        jbMessage.setText("黑方下子");
                    }
                    this.repaint();
                }
            }
        }
        if(e.getSource() == reply) {

        }
    }


    // jPMain部分
    class PaintBoard extends JPanel implements MouseListener {
        public PaintBoard() {
                this.addMouseListener(this);
            }
            @Override
            protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            width = this.getSize().width; //面板大小
             height = this.getSize().height;
             //  棋盘大小
              boardWidth = 600;
              boardHeight = 600;
              // 左上角第一个点,为了让面板居中
               xbase = (width - boardWidth) / 2;
               ybase = (height - boardHeight) / 2;
               Graphics2D g2d = (Graphics2D) g;
               int x0, y0, x1, y1;//画线的时候用到的四个点
               this.setBackground(new Color(246, 186, 114));
               for (int i = 0; i <= 18; i++) {
                   if (i == 0 || i == 18) {
                        //调整画线的大小
                       g2d.setStroke(new BasicStroke(3.0f));    //画棋盘边界时，线条加粗。setStroke()方法设置线条粗细,

                    } else {
                       g2d.setStroke(new BasicStroke(1.0f));
                    }
                    //开始确定每一个点的坐标,然后画行
                    x0 = xbase;
                    y0 = ybase + i * temp;
                    x1 = xbase + 18 * temp;
                    y1 = ybase + i * temp;
                    g2d.drawLine(x0, y0, x1, y1);
                    // 开始画列
                    x0 = xbase + temp * i;
                    y0 = ybase;
                    x1 = xbase + temp * i;
                    y1 = ybase + 18 * temp;
                    g2d.drawLine(x0, y0, x1, y1);
               }
               int radius = 16;
                // 开始画黑心点圆和白心圆
                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 19; j++) {
                        if (allChess[i][j] == 1) {
                            g2d.setColor(Color.black);
                            g2d.fillOval(i * temp + xbase - radius / 2, j * temp + ybase - 7, radius, radius);
                        } else if (allChess[i][j] == 2) {
                            g2d.setColor(Color.white);
                            g2d.fillOval(i * temp + xbase - radius / 2, j * temp + ybase - 7, radius, radius);
                            g2d.drawOval(i * temp + xbase - radius / 2, j * temp + ybase - 7, radius, radius);
                        }

                    }
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (canPlay) {
                    x = e.getX();
                    y = e.getY();
                    //  判断鼠标点击位置
                    if (x >= xbase & x <= (xbase + 18 * temp) & y >= ybase & y < (ybase + 18 * temp)) {
                        // 判断是不是下在空的位置
                        int tempX = (x - xbase) / temp, tempY = (y - ybase) / temp;
                        if ((x - xbase) % temp > temp / 2) {
                            x = tempX + 1;
                        } else
                            x = tempX;
                        if ((y - ybase) % temp > temp / 2)
                            y = tempY + 1;
                        else
                            y = tempY;
                        // 先判断有没有棋子，处理有棋子的情况
                        if (allChess[x][y] != 0) {
                            JOptionPane.showMessageDialog(this, "这里有棋子了");
                        } else {
                            chessX[countx++] = x;
                            chessY[county++] = y;
                            if (isBlack) {
                                System.out.println(x + "," + y);
                                allChess[x][y] = 1;
                                isBlack = false;
                                jbMessage.setText("白方下子");
                            } else {
                                System.out.println(x + "," + y);
                                allChess[x][y] = 2;
                                isBlack = true;
                                jbMessage.setText("黑方下子");
                            }
                            this.repaint();
                            if (isWin()) {
                                if(isBlack == false) {
                                    JOptionPane.showMessageDialog(this, "黑方胜利!");
                                }else {
                                    JOptionPane.showMessageDialog(this, "白方胜利!");
                                }
                                canPlay = false;
                            }
                            //平局判断
                            int a=0;
                            for(int i = 1;i<18;i++) {
                                for(int j = 1;j<18;j++) {
                                    if(allChess[i][j] != 0) {
                                        a++;
                                    }
                                }
                            }
                            System.out.println("棋盘上有"+a+"个棋子");
                            if(a==289) {
                                JOptionPane.showMessageDialog(this, "平局!");
                                canPlay = false;
                            }
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            // 判断是不是赢了
            private boolean isWin() {
                int color = allChess[x][y];
                int count;
                count = this.Count(1, 0, color);
                if (count >= 5) {
                    return true;
                } else {
                    count = this.Count(0, 1, color);
                    if (count >= 5) {
                        return true;
                    } else {
                        count = this.Count(1, 1, color);
                        if (count >= 5)
                            return true;
                        else {
                            count = this.Count(1, -1, color);
                            if (count >= 5)
                                return true;
                        }
                    }
                }
                return false;
            }
            private int Count(int xChange, int yChange, int color) {
                int count = 1;
                int tempX = xChange, tempY = yChange;
                while (color == allChess[x + xChange][y + yChange]) {
                    count++;
                    if (xChange != 0) {
                        xChange++;
                    }
                    if (yChange != 0) {
                        if (yChange > 0)
                            yChange++;
                        else
                            yChange--;
                    }
                }
                xChange = tempX;
                yChange = tempY;
                while (color == allChess[x - xChange][y - yChange]) {
                    count++;
                    if (xChange != 0)
                        xChange++;
                    if (yChange != 0) {
                        if (yChange > 0)
                            yChange++;
                        else
                            yChange--;
                    }
                }
                return count;
        }
    }
}