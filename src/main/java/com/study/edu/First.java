package com.study.edu;

/**
 * Created by Administrator on 2018/3/5.
 */
public class First extends A{
    public First(){
        System.out.println("4");
    }
    public First(String s){
        System.out.println("3");
        new First();
    }
    public static void main(String [] args) throws InterruptedException {
        /*for (int i=0;i<100;i++){
            System.out.println("the times:"+i);
            Thread.sleep(1000);
            Integer a = new Integer(1);
            int b = 1;
            System.out.println(a == b);
        }
        Integer a = new Integer(200);
        int b = 200;
        Integer c = 200;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a.equals(b));
        String s = "b";
        String ss = new String("b");
        String sss = "b";
        System.out.println(s.equals(ss));
        System.out.println(s == ss);
        System.out.println(s == sss);*/
        new First("s");
    }


}
class A{
    public A(){
        System.out.println("1");
    }
    public A(String s){
        System.out.println("2");
    }
}
