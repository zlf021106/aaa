package ch8;

import java.io.*;

public class ObjectOutputTest2 {
    public static void main(String[] args) throws Exception {
    ObjectOutputTest test = new ObjectOutputTest();
    Employee em = new Employee(29,"james",4000f);
    test.WriteObj(em);
}
    public void WriteObj(Object obj) throws Exception {
        BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream("D:\\obj.ini"));
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
        fo.close();
    }
}

