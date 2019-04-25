package topico6a.slide12.Ex2;

import java.time.LocalTime;

/**
 *
 * @author itsgnegrao
 */
public class Monitor {

    private long countMax;
    private long count;
    private Process process;
    private boolean wakeUp;

    public synchronized void sleepUntil(long value, Process process) {
        this.process = process;
        this.countMax = value;
        this.count = 0;
        
        while (!(count <= countMax)) {
            try {
                this.process.sleep(10);
            } catch (Exception e) {
            }
        }

        this.wakeUp = false;
        System.out.println(LocalTime.now()+" - Processo " + this.process.getName() + " Dormiu!");
    }

    public synchronized boolean increment() {
        while (!wakeUp) {
            try {
                count++;
                wakeUp = (count >= countMax);
            } catch (Exception e) {
            }
        }
        System.out.println(LocalTime.now()+" - Processo " + this.process.getName() + " Acordou!");
        return false;
    }

}
