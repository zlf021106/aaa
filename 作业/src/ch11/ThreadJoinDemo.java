package ch11;

public class ThreadJoinDemo extends Thread {
    public void run() {
        for(int i=1;i<=3;i++) {
            System.out.println(Thread.currentThread().getName() + "第" + i + "次运行");
        }
    }

    public static void main(String[] args) {
        ThreadJoinDemo t1 = new ThreadJoinDemo();
        ThreadJoinDemo t2 = new ThreadJoinDemo();
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("出现错误，错误信息是"+e.getMessage());
        }
    }
}
