package topico6a.slide12.Ex3;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itsgnegrao
 */
public class Monitor {

    private long countMax;
    private long countMin;
    private long count;

    public Monitor(long countMin, long countMax) {
        this.countMax = countMax;
        this.countMin = countMin;
        this.setCount();
    }

    private void setCount() {
        this.count = (this.countMin + this.countMax) / 2;
    }

    private boolean verifyCount() {
        System.out.println(this.count);
        if (this.count > this.countMax) {
            return true;
        } else if (this.count < this.countMin) {
            return true;
        }
        return false;
    }

    public synchronized boolean decrement() {
        this.count--;
        if (this.verifyCount()) {
            setCount();
            return true;
        }
        return false;
    }

    public synchronized boolean increment() {
        this.count++;
        if (this.verifyCount()) {
            setCount();
            return true;
        }
        return false;
    }

}
