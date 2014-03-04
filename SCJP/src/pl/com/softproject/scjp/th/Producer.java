/*
 * Copyright 2011-08-31 the original author or authors.
 */

package pl.com.softproject.scjp.th;

import java.util.Random;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Producer implements Runnable {

    private Storage storage;

    public Producer(Storage s) {
        storage = s;

    }

    public void run() {
        Random r = new Random();
        for (int i = 0;; i++) {
            char c = (char) (r.nextInt(80) + 40);
            System.out.println("-> Produced: " + c);
            System.out.println("-> Storing...");
            storage.push(c);
            System.out.println("-> Stored: " + c);

        }
    }
}
