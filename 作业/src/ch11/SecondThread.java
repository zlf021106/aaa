package ch11;

public class SecondThread implements Runnable {
    private String name;
    public SecondThread(String name) {
        this.name=name;
        System.out.println(name+"创建成功");
    }
    public void run() {
        for(int i=0;i<3;i++) {
            System.out.println(name+"第"+"次运行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        SecondThread r1 = new SecondThread("第一个线程");//创建参数对象
        SecondThread r2 = new SecondThread("第二个线程");
        Thread t1 = new Thread(r1);//创建线程对象
        Thread t2 = new Thread(r2);
        System.out.println("开始启动t1,t2线程");
         t1.start();
         t2.start();
        System.out.println("main方法运行完毕");
    }
}
