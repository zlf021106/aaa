public class text2 {
    public static void main(String[] args){
        int num1=1;
        int num2=1;
        int count =1;
        System.out.print("1 1");
        while(count<=28){
            int temp=num1;
            num1=num2;
            num2+=temp;
            System.out.print(num2+" ");
            count+=1;
        }
    }
}
