package edu.phystech.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;


class ConcurrentCounter {


    private final AtomicLong value = new AtomicLong(0);

    void increment() {
        value.incrementAndGet();
    }

    long getValue() {
        return value.longValue();
    }


}


public class ConcurrentCounterTest {

    @Test
    void justWorks() {
        ConcurrentCounter concurrentCounter = new ConcurrentCounter();
        IntStream.range(0, 100_000).forEach(i -> concurrentCounter.increment());
        Assertions.assertEquals(100_000, concurrentCounter.getValue());
    }


    @Test
    void worksWithConcurrentIncrement() throws InterruptedException {
        ConcurrentCounter concurrentCounter = new ConcurrentCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callableList = IntStream.range(0, 100_000).mapToObj(i -> (Callable<Integer>) () -> {
            concurrentCounter.increment();
            return 0;
        }).toList();
        executorService.invokeAll(callableList).forEach(f -> {
            try {
                f.get();
            } catch (Exception e) {
            }
        });
        Assertions.assertEquals(100_000, concurrentCounter.getValue());
    }
}
