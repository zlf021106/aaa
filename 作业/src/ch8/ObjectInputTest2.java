package ch8;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputTest2 {
    public static void main(String[] args) throws Exception {
    ObjectInputTest test = new ObjectInputTest();
    System.out.println(((Employee) test.ReadObj()).getName());
}
    public Object ReadObj() throws Exception {
        BufferedInputStream fi = new BufferedInputStream(new FileInputStream("D:\\obj.ini"));
        ObjectInputStream ois = null;
        Object obj = null;
        ois = new ObjectInputStream(fi);
        obj = ois.readObject();
        ois.close();
        fi.close();
        return obj;
    }
}
