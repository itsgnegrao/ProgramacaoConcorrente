package topico6.slide16;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itsgnegrao
 */
public class Producer extends Thread {

    private static int value[] = new int[1];
    private static boolean hasData = false;
    private static int maxSizeBuff = 0;
    
    public Producer(int val) {
        this.maxSizeBuff = val;
    }

    public void produce() {
        synchronized (this) {
            int size = new Random().nextInt(maxSizeBuff);
            int buff[] = new int[size];

            for (int i = 0; i < size; i++) {
                buff[i] = new Random().nextInt();
            }

            value = buff;
            notify();
            hasData = true;
        }
    }

    public static int[] getvalue() {
        boolean flag = hasData;
        if (hasData) {
            hasData = false;
        }
        return (flag ? value : null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                produce();
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
