public class 随机存数 {
public static void main(String[] args){
    int[] arr=new int[20];
    for(int i=0;i<arr.length;i++){
        arr[i]=(int)(Math.random()*382+77);
    }
    int max=arr[0];
    int min=arr[0];
    int sum=0;
    int average=0;
    for(int i=0;i<arr.length;i++){
        if(max<arr[i]){
            max=arr[i];
        }
        if(min>arr[i]){
            min=arr[i];
        }
        sum+=arr[i];
        average=sum/20;
    }
    System.out.println("最大值："+max);
    System.out.println("最小值："+min);
    System.out.println("平均值："+average);
    System.out.println("各元素和为："+sum);
}
}
