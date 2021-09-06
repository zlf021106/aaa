import java.util.Scanner;
public class text5{
    public static void main(String[] args){
        System.out.println("请输入数字个数:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int  i,sum=0;
        double aver;
        for( i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        aver=sum/n;
        for(i=0;i<arr.length;i++){
            if(arr[i]>aver){
                System.out.println("arr["+i+"]="+arr[i]);
            }
        }
    }
}
