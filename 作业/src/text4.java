public class text4{
    public static void main(String[] args) {
        String str1 = "ABadgeIAdj";
        int[] count = new int[52];
        for(int i=0; i<str1.length(); i++){
            char tmp = str1.charAt(i);
            if((tmp>=65&& tmp<=90)||(tmp>=97&& tmp<=122)){
                int index = tmp - 65;
                count[index] = count[index] + 1;
            }
        }
        for(int j=0; j<count.length; j++){
            if(count[j]!=0)
                System.out.println("字母"+(char)(j+65)+"出现次数："+count[j]);
        }
    }
}
