package ch7;

public class ReverseArray {
    int num1 = 10;
    static int num2 = 20;
    public static void show() {
      //System.out.println(num1);     静态方法中没有对象this，所以不能访问非静态成员
        System.out.println(num2);
    }
    public static void reverse(int[] arr) {
        for(int i=0;i<arr.length/2;i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
    public static void main(String[] args) {
        ReverseArray.show();
        int[] arr = {1,2,3,4,5,6};
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }

        System.out.println("-------------------");
        ReverseArray.reverse(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
