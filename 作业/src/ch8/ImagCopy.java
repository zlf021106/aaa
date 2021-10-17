package ch8;

import java.io.*;

public class ImagCopy {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\MNLS.jpg");
        FileInputStream fin = new FileInputStream(file);
        FileOutputStream fo = new FileOutputStream(new File("E:\\a.jpg"));
        int num = 0;
        if(!file.exists()) {
            System.out.println("源文件不存在");
        } else {
            while((num = fin.read()) != -1) {
                fo.write(num);
            }
            fo.flush();
            fin.close();
            fo.close();
        }
    }
}
