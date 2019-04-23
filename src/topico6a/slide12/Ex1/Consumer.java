package topico6a.slide12.Ex1;

/**
 *
 * @author itsgnegrao
 */
public class Consumer extends Thread {

    private static Monitor monitor;

    public Consumer(Monitor monitor) {
        this.monitor = monitor;
    }

    private static void consume() {
        int buff = monitor.consume();
        System.out.println("Consumer " + Thread.currentThread().getName() + "Recebi o buff " + buff);
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }
}
