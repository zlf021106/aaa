package 非作业;

import java.io.*;

public class CopyFile7 {
    public static void main(String[] args) throws IOException {
      /*  FileInputStream fis = new FileInputStream("lib/a.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);  */
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("lib/a.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("lib/b.jpg"));
        int len;
        while((len = bis.read())!= -1) {
            bos.write(len);
        }
        bis.close();
        bos.close();
    }
}
