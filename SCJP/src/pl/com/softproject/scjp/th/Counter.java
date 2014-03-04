/*
 * Copyright 2013-03-08 the original author or authors.
 */
package pl.com.softproject.scjp.th;

/**
 *
 * @author Adrian Lapierre <alapierre@softproject.com.pl>
 */
public class Counter {
    
    private int i;
    
    public int increment() {
        return i++;
    }
    
    public static void main(String[] args) {
        
        final Counter counter = new Counter();
        
        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i<1000; i++)
                    System.out.println("wątek 1 " + Thread.currentThread().getName() + " " + counter.increment());
            }
        });
        
        Thread th2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i<1000; i++)
                    System.out.println("wątek 2 " + Thread.currentThread().getName() + " " + counter.increment());
            }
        });
    
    
        th1.start();
        th2.start();
        
    }
    
    
    
}
