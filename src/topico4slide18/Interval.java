package topico4slide18;

/**
 *
 * @author itsgnegrao
 */
public class Interval {
    private int endInterval = 0;
    private int value = 0;

    public Interval(int startInterval, int endInterval){
        this.value = startInterval;
        this.endInterval = endInterval;
    }

    public int getNext(){
        int ret = value;
        value++;
        return (ret <= endInterval ? ret : -1);
    }
}
