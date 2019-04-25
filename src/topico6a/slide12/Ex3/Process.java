package topico6a.slide12.Ex3;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itsgnegrao
 */
public class Process extends Thread {

    private Monitor monitor;
    private boolean func;
    private int Time;

    public Process(Monitor monitor, boolean func, int Time) {
        this.monitor = monitor;
        this.func = func;
        this.Time = Time;
    }

    private synchronized void callfunc() {
        try {
            if (this.func) {
                if (this.monitor.increment()) {
                    System.out.println(LocalTime.now() + " - Processo " + this.getName() + " Bloqueado!");
                    this.interrupt();
                }
                sleep(this.Time);
            } else {
                if (this.monitor.decrement()) {
                    System.out.println(LocalTime.now() + " - Processo " + this.getName() + " Bloqueado!");
                    this.interrupt();
                }
                sleep(this.Time);
            }
        } catch (InterruptedException ex) {
            while(true) yield();
        }

    }

    @Override
    public void run() {
        while (true) {
            this.callfunc();
        }
    }
}
