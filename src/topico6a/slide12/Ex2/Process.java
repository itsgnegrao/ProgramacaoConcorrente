package topico6a.slide12.Ex2;

/**
 *
 * @author itsgnegrao
 */
public class Process extends Thread {

    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
