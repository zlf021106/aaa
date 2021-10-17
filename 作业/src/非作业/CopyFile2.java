package 非作业;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile2 {
    public static void main(String[] args) throws IOException {
        //通过字符流拷贝文件，一次读写一个字符数组
        /*I流核心六步：
        1.创建字符输入流对象，并关联数据源文件
        2.创建字符流输出流对象，关联目的地文件
        3.创建变量，用来记录读取到的有效字符数
        4.通过循环进行读取，只要满足就一直读，并将读到的有效字符数赋值给变量
        5.将读到的数据写入到目的地文件中
        6.释放资源
         */
        FileReader fr = new FileReader("lib/1.txt");
        FileWriter fw = new FileWriter("lib/2.txt");
        char[] chs = new char[1024];
        int len;
        while((len = fr.read(chs)) != -1) {
            fw.write(chs,0,len);
        }
        fr.close();
        fw.close();
    }
}
