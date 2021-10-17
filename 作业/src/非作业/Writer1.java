package 非作业;

import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

public class Writer1 {
    public static void main(String[] args) throws IOException {
        //创建字符输入数组
        Writer writer = new FileWriter("lib/1.txt");
        //写数据
        /*一次写一个字符
        writer.write('好');    */

        /*一次写一个指定的字符数组
        char[] chs = {'黑','马','程','序','员'};
        writer.write(chs,0,3);  */

        //一次写一个字符串
        writer.write("好好学习，天天向上");

        //释放资源
        writer.close();


    }
}
