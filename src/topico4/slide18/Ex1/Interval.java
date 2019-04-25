package topico4.slide18.Ex1;

/**
 *
 * @author itsgnegrao
 */
public class Interval {

    private int endInterval = 0;
    private int value = 0;

    public Interval(int startInterval, int endInterval) {
        this.value = startInterval;
        this.endInterval = endInterval;
    }

    public int getNext() {
        return (value++ < endInterval ? value : -1);
    }
}
