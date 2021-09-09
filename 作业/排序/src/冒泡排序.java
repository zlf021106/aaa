public class 冒泡排序 {
    public static void sort (int a[]){
        int temp=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    temp= a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
    public static void main(String args[]){
        int[] b=new int[]{13,23,43,45,65,67};
        sort(b);
        for(int i=0;i<b.length;i++)
            System.out.print(b[i]+",");
    }
}
