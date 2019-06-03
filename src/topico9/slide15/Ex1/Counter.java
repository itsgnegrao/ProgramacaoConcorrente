package topico9.slide15.Ex1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author itsgnegrao
 */
public class Counter {

    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    private void increment() {
        this.counter++;
    }

    private void descrement() {
        this.counter--;
    }

    public boolean modify(boolean method) {
        this.lock.lock();
        try {
            if (method) {
                this.increment();
            } else {
                this.descrement();
            }
            System.out.println(counter);
        } finally {
            this.lock.unlock();
            return true;
        }
    }

}
