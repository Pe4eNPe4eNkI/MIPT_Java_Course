package edu.phystech.hw4;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTicketLock {
    private final AtomicInteger nextTicket = new AtomicInteger();
    private final AtomicInteger currentTicket = new AtomicInteger();

    public void lock() {
        int ticket = nextTicket.getAndIncrement();

        while (ticket != currentTicket.intValue()) {
        }

    }

    public void unlock() {
        currentTicket.incrementAndGet();
    }
}