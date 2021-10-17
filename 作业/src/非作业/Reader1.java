package 非作业;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Reader1 {
    public static void main(String[] args) throws IOException {
        //通过字符流读取数据
        //1.创建字符输入流对象
        Reader reader = new FileReader("lib/1.txt");

        //2.读取数据,读取文件的一个字符，全部读取输出-1
       /* int ch1 = reader.read();
        System.out.println(ch1);
        int ch2 = reader.read();
        System.out.println(ch2);
        int ch3 = reader.read();
        System.out.println(ch3);
        int ch4 = reader.read();
        System.out.println(ch4);*/

        int ch;//用循环改进
        while((ch = reader.read())!= -1) {
            System.out.println(ch);

            //释放资源
            reader.close();
        }
    }
}
