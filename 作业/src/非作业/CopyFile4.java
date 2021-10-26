package 非作业;

import java.io.*;

public class CopyFile4 {
    public static void main(String[] args) throws IOException {
        //通过字符缓冲流一次读写一行的方式，拷贝文件(只能拷贝文本文件)
        BufferedReader br = new BufferedReader(new FileReader("lib/1.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("lib/2.txt"));
        String str;
        while((str = br.readLine()) != null) {
            bw.write(str);
            //bw.write("\r\n");  window操作系统换行符为:  \r\n       mac操作系统   \r      unix操作系统为  \n
            bw.newLine();
            br.close();
            bw.close();
        }
    }
}
