package 非作业;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class CopyFile3 {
    public static void main(String[] args) throws IOException {
        //通过字符缓冲流，将文件拷贝
        //特点：字符缓冲流自带有缓冲区，大小为8192个字符，也就是16KB。
        //1.创建字符缓冲输入流对象，关联数据源文件
        //2.创建字符缓冲输出流对象，关联目的地文件
        //3.定义变量，记录读取到的数据
        //4.循环读取，只要满足条件就一直读，并将读取到的内容赋值给变量
        //5.将读取到的数据写入到目的地文件中
        //6.释放资源
       BufferedReader br = new BufferedReader(new FileReader("lib/1.txt"));
       BufferedWriter bw = new BufferedWriter(new FileWriter("lib/2.txt"));
       int len;
       while((len = br.read()) != -1) {
           bw.write(len);
           br.close();
           bw.close();
       }
    }
}
