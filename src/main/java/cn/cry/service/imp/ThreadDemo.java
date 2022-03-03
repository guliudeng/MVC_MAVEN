package cn.cry.service.imp;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
    public static void main(String[] args) {
        th th1 = new th();
        th th2 = new th();
        th th3 = new th();
        th1.start();
        th2.start();
        th3.start();
    }
}

class th extends Thread{
    int  num = 200;
    @Override
    public   void run() {
        while (num>0) {
            System.out.println("当前线程"+Thread.currentThread().getName()+"售出一次，剩余"+(--num));
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public synchronized void methodB(int num) {
        System.out.println("数量减一");
        --num;
    }
}
class  lock{
    public synchronized void methodA(int num) {
        System.out.println("数量减一");
        --num;
     /*   ReentrantLock reentrantLock = new ReentrantLock;
        reentrantLock.lock();
        Condition condition = reentrantLock.newCondition();
        condition.await();*/
    }
}
