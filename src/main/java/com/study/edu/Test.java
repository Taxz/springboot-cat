package com.study.edu;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;



/**
 * Created by Administrator on 2018/2/28.
 */

public class Test {
    public static void main(String args[]){
        for(int j1=0;j1<10;j1++) {
            Transaction t = Cat.newTransaction("TXZ12","test");
            Cat.logEvent("Method_test1","good1");
            Cat.logEvent("Method_event1","bad1");
            try{
                t.setStatus("Fail1");
            }catch (Exception e){
                t.setStatus(Transaction.SUCCESS);
                Cat.logError(new Exception("exception"));
            }finally {
                t.complete();
            }
        }
    }
    @org.junit.Test
    public void mains() throws InterruptedException {
        for(int j=0;j<10;j++) {
        Transaction t = Cat.newTransaction("TXZ2","test");
        Cat.logEvent("Method_test1","good1");
        Cat.logEvent("Method_event1","bad1");
            try{
                t.setStatus("Fail");
            }catch (Exception e){
                t.setStatus(Transaction.SUCCESS);
                Cat.logError(new Exception("exception"));
            }finally {
                t.complete();
            }
        }
        Thread.sleep(10000);
    }

    @org.junit.Test
    public void mai() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Transaction t1 = Cat.newTransaction("haha1", "go");
            Cat.logEvent("Method_test","good");
            Cat.logEvent("Method_event","bad");
            try {
                t1.setStatus("Fail1");

            } catch (Exception e) {
                t1.setStatus(Transaction.SUCCESS);
                Cat.logError(e);
                throw e;
            } finally {
                t1.complete();
            }
        }
        Thread.sleep(10000);
    }

    @org.junit.Test
    public void sendException() throws Exception {
        for (int i = 0; i < 10; i++) {
            Transaction t = Cat.newTransaction("haha", "go");
            try {
                t.setStatus("Fail");

                //DefaultMessageTree tree =(DefaultMessageTree) Cat.getManager().getThreadLocalMessageTree();

               // tree.setDomain("dffddgfd");
            } catch (Exception e) {
                t.setStatus(Transaction.SUCCESS);
                Cat.logError(e);
                throw e;
            } finally {
                t.complete();
            }
        }
        Thread.sleep(10000);
    }
}
