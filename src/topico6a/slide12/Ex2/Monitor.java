package topico6a.slide12.Ex2;

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
        while (!(count <= countMax)) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.process = process;
        this.countMax = value;
        this.count = 0;
        this.process.interrupt();
        this.wakeUp = false;
        System.out.println("Processo " + this.process.getName() + " Dormiu!");
    }

    public synchronized boolean increment() {
        while (!wakeUp) {
            try {
                count++;
                System.out.println(count);
                wakeUp = (count >= countMax);
            } catch (Exception e) {
            }
        }
        System.out.println("Processo " + this.process.getName() + " Acordou!");
        return false;
    }

}
