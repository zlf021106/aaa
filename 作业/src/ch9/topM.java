package ch9;

import java.util.*;

public class topM {
    private static  void printlist(Collection<Student> slist) {
        for(Student stu:slist) {
            System.out.println(stu);
        }
    }
    private static List<Integer> GetTopM(List<Integer> list, int m) {
        List<Integer> ret = new ArrayList();
        Collections.sort(list);
        for(int i=list.size()-1;i>=0&&ret.size()<m;i--) {
            ret.add(list.get(i));
        }
        System.out.println(m+"-----"+list.size()+"----"+ret.size());
        return ret;
    }

    private static  List<Integer> GetTopM2(List<Integer>list,int m) {
        List<Integer> ret = new ArrayList();
        ret.add(list.get(0));
        for(int i=1;i<list.size();i++) {
            if(ret.size()>m&&list.get(i)<ret.get(ret.size()-1))
                continue;
            for(int j=0;j<ret.size();j++) {
                if(ret.get(j)<list.get(i)) {
                    ret.add(j,list.get(i));
                    break;
                }
            }
            if(ret.size()>m)
                ret.remove(ret.size()-1);
            }
        System.out.println(m+"----"+list.size()+"----"+ret.size());
        return ret;
    }

    private static <T extends Comparable> List<T> GetTopM3(List<T> list,int m) {
        List<T> ret = new ArrayList();
        ret.add(list.get(0));
        for(int i=1;i<list.size();i++) {
            if(ret.size()>m&&list.get(i).compareTo(ret.get(ret.size()-1))<0)
                continue;
            for(int j=0;j<ret.size();j++) {
                if(ret.get(j).compareTo(list.get(i))<0) {
                    ret.add(j,list.get(i));
                    break;
                }
            }
            if(ret.size()>m)
                ret.remove(ret.size()-1);
        }
        System.out.println(m+"----"+list.size()+"----"+ret.size());
        return ret;
    }

    public static void main(String[] args) {
        Random rm = new Random();
        rm.setSeed(System.currentTimeMillis());
        int n=100000000,m=50;
        List<Integer> list = new ArrayList();
        for(int i=0;i<n;i++)
            list.add(rm.nextInt());
        long start = System.currentTimeMillis();
        List<Integer> ret = GetTopM2(list,m);
        System.out.println("计算时间"+(double)(System.currentTimeMillis()-start)/1000+"秒");
 //       System.out.println(list);
        System.out.println(ret);
        List<Student> stuList = new ArrayList<Student>();
        stuList.add(new Student("姜文武",1001L,(double) 97.0f));
        stuList.add(new Student("汪兴宇",1002L,(double) 98.0f));
        stuList.add(new Student("余博文",1003L,(double) 95.0f));
        printlist(stuList);
        List<Student> ret2=GetTopM3(stuList,2);
        printlist(ret2);
        System.out.println("------------------");
    }
}
