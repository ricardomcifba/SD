package threads;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ads
 */
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Programa {

    int itemCount;
    ArrayList buffer;
    MultiThread x;
    Semaphore mutex = new Semaphore(1);
    Semaphore itens = new Semaphore(0);

    Programa() {
        itemCount = 0;
        buffer = new ArrayList();
    }

    int compartilhada;

    public static void main(String[] args) {
        Programa t = new Programa();
        t.run();
    }

    public void run() {

        Consumer c = new Consumer(this);
        Producer p = new Producer(this);
        p.start();
        c.start();
//        UmaThread t1 = new UmaThread(c.getName(), x, itemCount);
//        UmaThread t2 = new UmaThread(p.getName(), x, itemCount);
//        t1.start();
//        t2.start();
        Consumer c1 = new Consumer(this);
        Producer p1 = new Producer(this);
        p1.start();
        c1.start();
//        UmaThread t3 = new UmaThread(c1.getName(), x, itemCount);
//        UmaThread t4 = new UmaThread(p1.getName(), x, itemCount);
//        t3.start();
//        t4.start();
    }

}
