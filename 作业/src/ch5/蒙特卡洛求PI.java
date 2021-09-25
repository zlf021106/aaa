package ch5;

public class 蒙特卡洛求PI {
    public static void main(String[] args) {
        int n=10000;
        int count=0;
        for(int i=0;i<=n;i++) {
            double x = Math.random();
            double y = Math.random();
            if(x*x+y*y<1) {
                count++;
            }
        }
        System.out.println("PI="+4*count/n);
    }
}
