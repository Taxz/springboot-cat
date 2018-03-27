package com.study.utill;

/**
 * Created by Administrator on 2018/3/22.
 */
public class ProductAndComsumer {

    public static void main(String []args){
        Object obj = new Object();
        Product p=new Product(obj);
        A a =new A();
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        a.setV();
                        //p.setValue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Consumer c=new Consumer(obj);
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    try {
                        a.getV();
                        //c.getValue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
class A{
    public static String string = "";
    public synchronized void setV() throws InterruptedException {
        if (!A.string.equals("")){
            this.wait();
        }
        A.string ="sss";
        System.out.println("生成了。。");
        this.notifyAll();
    }
    public synchronized void getV() throws InterruptedException {
        if (A.string.equals("")){
            this.wait();
        }
        A.string ="";
        System.out.println("消费了。。");
        this.notifyAll();
    }
}
class Product{
    public Object obj;

    public Product(Object obj) {
        this.obj = obj;
    }

    public void setValue() throws InterruptedException {
        synchronized (obj){
            if (!A.string.equals("")){
                obj.wait();
            }
            A.string ="sss";
            System.out.println("生产了。。");
            obj.notifyAll();
        }
    }
}
class Consumer{
    public Object obj;

    public Consumer(Object obj) {
        this.obj = obj;
    }

    public void getValue() throws InterruptedException {
        synchronized (obj){
            if (A.string.equals("")){
                obj.wait();
            }
            A.string ="";
            System.out.println("消费了。。。");
            obj.notifyAll();
        }
    }
}