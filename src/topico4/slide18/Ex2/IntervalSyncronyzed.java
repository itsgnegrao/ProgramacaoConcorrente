package topico4.slide18.Ex2;

/**
 *
 * @author itsgnegrao
 */
public class IntervalSyncronyzed {
    private int endInterval = 0;
    private int value = 0;

    public IntervalSyncronyzed(int startInterval, int endInterval){
        this.value = startInterval;
        this.endInterval = endInterval;
    }

    public synchronized int getNext(){
        int ret = value;
        value++;
        return (ret <= endInterval ? ret : -1);
    }
}
