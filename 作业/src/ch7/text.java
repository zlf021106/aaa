package ch7;

public class text {
    public static void main(String[] args) {
        String s = new String("a");
        StringBuffer sb = new StringBuffer("a");
        double start = System.currentTimeMillis();
        double start2 = System.currentTimeMillis();
        for(int i=0;i<=10000;i++) {
            s = s.concat("a");
            sb = sb.append("a");
        }
        double end = System.currentTimeMillis();
        double end2 = System.currentTimeMillis();
        System.out.println(s);
        System.out.println(end-start+"ms");
        System.out.println(sb);
        System.out.println(end-start+"ms");
    }
}
