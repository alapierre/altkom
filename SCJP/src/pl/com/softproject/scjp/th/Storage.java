/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.scjp.th;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Storage {

    private static final int LIMIT = 50;
    private int indx = 0;
    private char tab[] = new char[LIMIT];

    synchronized void push(char c) {
        while (indx == LIMIT) {
            try {
                System.out.println("Nadmiar towaru - czekam!! (" + Thread.currentThread().getName() + ")");
                wait();
                System.out.println("po wait !! (" + Thread.currentThread().getName() + ")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Przed notyfikacja (push) (" + Thread.currentThread().getName() + ")");
        notify();
        System.out.println("Po notyfikacji (push) (" + Thread.currentThread().getName() + ")");
        tab[indx] = c;
        indx++;
    }

    synchronized char pop() {
        while (indx == 0) {
            System.out.println("brak towaru - czekam (" + Thread.currentThread().getName() + ")");
            try {
                wait();
                System.out.println("po wait - jest towar? (" + Thread.currentThread().getName() + ")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Przed notyfikacja (pop) (" + Thread.currentThread().getName() + ")");
        notify();
        System.out.println("Po notyfikacji (pop) (" + Thread.currentThread().getName() + ")");
        indx--;
        return tab[indx];
    }

    public static void main(String[] args) throws InterruptedException {
        
        Storage s = new Storage();
        Producer producer = new Producer(s);
        Consumer consumer1 = new Consumer(s);
        Consumer consumer2 = new Consumer(s);
        
        Thread consumerThread1 = new Thread(consumer1);
        consumerThread1.setName("Consument 1");
        consumerThread1.start();
        
        Thread consumerThread2 = new Thread(consumer2);
        consumerThread2.setName("Consument 2");
        consumerThread2.start();
                
        Thread producerThread = new Thread(producer);
        producerThread.setName("Producent");
        producerThread.start();
    }
}