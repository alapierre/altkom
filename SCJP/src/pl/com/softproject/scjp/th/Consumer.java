/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.scjp.th;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Consumer implements Runnable {

    private Storage storage;

    public Consumer(Storage s) {
        storage = s;
    }

    public void run() {
        for (int i = 0;; i++) {
            System.out.println("<- Consuming... (" + Thread.currentThread().getName() + ")");
            char c = storage.pop();
            System.out.println("<- Consumed " + c + " (" + Thread.currentThread().getName() + ")");
        }
    }
}
