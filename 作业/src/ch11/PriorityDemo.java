package ch11;

public class PriorityDemo extends Thread {
    public void run() {
        for(int i=1;i<=5;i++) {
            System.out.println(Thread.currentThread().getName()+"第"+i+"次运行");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        PriorityDemo t1 = new PriorityDemo();
        PriorityDemo t2 = new PriorityDemo();
        PriorityDemo t3 = new PriorityDemo();
        t1.setPriority(Thread.MAX_PRIORITY);//10
        t2.setPriority(Thread.NORM_PRIORITY);//5 默认
        t3.setPriority(Thread.MIN_PRIORITY);//1
        t1.start();
        t2.start();
        t3.start();
    }
}
