package topico6a.slide12.Ex1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itsgnegrao
 */
public class Producer extends Thread {

    private static Monitor monitor;

    public Producer(Monitor monitor) {
        this.monitor = monitor;
    }

    public void produce() {
        int value = new Random().nextInt(100);
        monitor.produce(value);
        System.out.println("Producer - produzi: " + value);
    }

    @Override
    public void run() {
        while (true) {
            produce();
        }
    }
}
