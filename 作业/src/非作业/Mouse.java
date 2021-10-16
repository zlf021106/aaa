package 非作业;

public class Mouse implements USB {
    @Override
    public void close() {
        System.out.println("连接鼠标");
    }

    @Override
    public void open() {
        System.out.println("断开连接鼠标");
    }
}

