package 非作业;

public class Coder extends Employee {
    public Coder() {
    }

    public Coder(String name, double salary, String id) {
        super(name, salary, id);
    }

    @Override
    public void work() {
        System.out.println("程序员在敲代码");

    }
}
