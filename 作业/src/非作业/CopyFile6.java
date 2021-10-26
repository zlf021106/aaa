package 非作业;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile6 {
    public static void main(String[] args) throws IOException {
        //普通字节流一次读写一个字符数组
        FileInputStream fis = new FileInputStream("lib/a.jpg");
        FileOutputStream fos = new FileOutputStream("lib/b.jpg");
        byte[] bys = new byte[1024];
        int len;
        while((len = fis.read(bys)) != -1) {
            fos.write(len);
        }
        fis.close();
        fos.close();
    }
}
