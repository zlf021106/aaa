import java.util.Scanner;
public class 最大公约数 {
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c;
        if(a>b){
            while(b!=0){
                a=a%b;
                if(a<b){
                    c=a;
                    a=b;
                    b=c;
                }
                if(a==b){
                    a=b;
                }
            }
        }
        System.out.println("最大公约数:"+a);
    }
}
