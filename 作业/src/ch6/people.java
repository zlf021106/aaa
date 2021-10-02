package ch6;

public class people {
    private  String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if(age<0||age>200)
            throw new AgeException();
        this.age = age;
    }

    public static void main(String[] args) {
        people p = new people();
        try {
            p.setAge(300);
        }catch (AgeException e) {
            System.out.println("给age赋值错误："+e.getMessage());
        }
    }
}
