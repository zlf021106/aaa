package 非作业;

public class text {
    public static void main(String[] args) {
        Employee em = new Coder();
        em.work();
        Employee em2 = new Manager();
        em2.work();
        //快速实例化对象
        Coder c = new Coder("张三", 30000, "研发部007");
        System.out.println("姓名" + c.getName());
        System.out.println("工资" + c.getSalary());
        System.out.println("工号" + c.getId());
        System.out.println("------------------");
        Manager m = new Manager("李四", 40000, "研发部001", 100000);
        System.out.println("姓名"+m.getName());
        System.out.println("工资"+m.getSalary());
        System.out.println("工号"+m.getId());
        System.out.println("奖金"+m.getBonus());
    }
}
