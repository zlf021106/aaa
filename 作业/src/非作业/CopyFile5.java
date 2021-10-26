package 非作业;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile5 {
    public static void main(String[] args) throws IOException {
        //普通字节流一次读写一个字节
        FileInputStream fis = new FileInputStream("lib/a..jpg");
        FileOutputStream fos = new FileOutputStream("lib/b.jpg");
        int len;
        while((len = fis.read()) != -1) {
            fos.write(len);
        }
        fis.close();
        fos.close();
    }
}
