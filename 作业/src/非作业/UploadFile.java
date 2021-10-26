package 非作业;

import java.io.*;
import java.util.Scanner;

public class UploadFile {
    public static void main(String[] args) {
        //模拟客户上传头像功能，假设所有的客户头像都应上传到：项目下的lib文件夹中
        //4.如果不存在，就上传该用户头像，并提示上传成功

        //1.定义一个方法，用来获取要上传的用户头像的路径 getPath()
        File path = getPath();
        System.out.println(path);
        //2.定义一个方法，用来判断要上传的用户头像，在lib文件夹中是否存在。
        boolean flag = isExists(path.getName());
        if(flag) {
            //3.如果存在，提示：用户头像已经存在，上传失败
            System.out.println("用户头像已经存在，上传失败");
        }else {
            System.out.println("上传成功");
        }
    }
    public static File getPath() {
        //1.提示用户录入要上传的用户头像路径，并接收
        Scanner sc = new Scanner(System.in);
        //7.因为不知道用户多少次能录入正确，所以用while(ture)改进
        while(true) {
            System.out.println("请录入您要录入的用户头像的路径：");
            String path = sc.nextLine();
            //2.判断该路径的后缀名是否为：.jpg,.png,.bmp
            //3.如果不是，就提示：你录入的不是图片，请重新录入；
            if(!path.endsWith(".jpg")&&!path.endsWith(".png")&&!path.endsWith(".bmp")) {
                System.out.println("您录入的不是图片，请重新录入");
                continue;
            }
            //4.如果是，程序接着执行，判断该路径是否存在，并且是否是文件
            File file = new File(path);
            if(file.exists()&&file.isFile()) {
                //6.如果是，说明就是我们想要的数据(图片，文件)，直接返回
                return file;
            }else {
                //5.如果不是，就提示:你录入的路径不合法，请重新录入
                System.out.println("您录入的路径不合法，请重新录入");
            }
        }
    }
    //2.定义一个方法，用来判断要上传的用户头像，在lib文件夹中是否存在。
    public static boolean isExists(String path) {
        //1.将lib文件夹中所有文件封装成File对象
        File file = new File("lib");
        //2.获取lib文件夹中所有的文件(夹)的名称数组
        String[] names = file.list();
        //3.遍历第二步获取的数组，用获取的数据一次和path比较
        for (String name : names) {
            if (name.equals(path)) {
                //4.如果一致，说明该用户头像已经存在了，就返回true
                return true;
            }
        }
        //5.如果不一致，说明该用户头像不存在，就返回false
        return false;
    }
    //定义方法，上传具体头像
    public static void uploadFile(File path) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("lib/"+path.getName()));
        int len;
        while((len = bis.read())!= -1) {
            bos.write(len);
        }
        bis.close();
        bos.close();
    }
}

