import java.util.Scanner;
public class text1{
    public static void main(String[] args) {
        System.out.println("请输入一个年份:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m=0;
        int k=n+100;
        for(;n<=k;n++){
            if((n%4==0&&n%100!=0)||n%400==0)
                m++;
        }
        System.out.print("能过闰年个数" +m);
    }
}
