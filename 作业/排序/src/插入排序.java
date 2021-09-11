import java.util.Scanner;
public class 插入排序 {
    public static void main(String[] args) {
        int j,temp;
        Scanner sc=new Scanner(System.in);
        int[] array =new int[6];
        for(int i=0;i<array.length;i++) {
            array[i] = sc.nextInt();
            temp=array[i];
            for(j=i-1;j>=0;j--) {
                if (temp > array[j]) {
                    break;
                }
                else {
                    array[j+1] = array[j];
                }
            }
            array[j+1]=temp;
        }
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
    }
}

