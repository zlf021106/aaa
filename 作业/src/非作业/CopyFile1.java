package 非作业;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class CopyFile1 {
    public static void main(String[] args) throws IOException {
        //通过字符流拷贝文件，一次读写一个字符
        /*IO流拷贝文件核心六步:
        1.创建字符输入对象，关联数据源文件
        2.创建字符输出流对象，关联目的地文件
        3.定义变量，记录读取到的内容
        4.循环读取，只要条件满足就一直读取，并将读取到的内容赋值给变量
        5.将读取到的数据写入到目的文件中
        6.释放资源
         */
        //1，
        FileReader fr = new FileReader("lib/1.txt");
        //2,
        FileWriter fw = new FileWriter("lib/2.txt");//如果目的地文件不存在，程序会自动创建
        //3,
        int len;
        //4,
        while((len = fr.read() )!= -1) {
            //5,
            fw.write(len);
        }
        //6,
        fr.close();
        fw.close();
    }
}
