package 非作业;

import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;

public class Reader2 {
    public static void main(String[] args) throws IOException {
        //创建字符输入对象
        Reader reader = new FileReader("lib/2.txt");
        //读取数据
        /*char[] chs = new char[3];// ,  ,(读取字符然后覆盖)
        int len1 = reader.read(chs);
        System.out.println(chs);//a,b,c
        System.out.println(len1);//3)(读取的字符个数)

        int len2 = reader.read(chs);
        System.out.println(chs);//d,e,f
        System.out.println(len2);//3

        int len3 = reader.read(chs);
        System.out.println(chs);//g,e,f
        System.out.println(len3);//1

        int len4 = reader.read(chs);
        System.out.println(chs);//g,e,f
        System.out.println(len4);//-1     */
        char[] chs = new char[3];//用循环改进
        int len;
        while((len = reader.read(chs))!= -1) {
            String s= new String(chs,0,len);
            System.out.println(s);
        }

        //释放资源
        reader.close();
    }
}
