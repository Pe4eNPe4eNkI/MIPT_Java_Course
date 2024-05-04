package edu.phystech.hw4;

import java.util.ArrayList;
import java.util.List;

public class Stepper {

    public enum Side {
        LEFT, RIGHT
    }

    private final List<Side> history = new ArrayList<>();
    private final Object lock = new Object();
    private boolean isLeftTurn = true;

    public void leftStep() {
        synchronized (lock) {
            while (!isLeftTurn) {
                try {
                    lock.wait();
                } catch (InterruptedException ignored) {}
            }
            history.add(Side.LEFT);
            isLeftTurn = false;
            lock.notifyAll();
        }
    }

    public void rightStep() {
        synchronized (lock) {
            while (isLeftTurn) {
                try {
                    lock.wait();
                } catch (InterruptedException ignored) {}
            }
            history.add(Side.RIGHT);
            isLeftTurn = true;
            lock.notifyAll();
        }
    }

    public List<Side> getHistory() {
        return history;
    }
}