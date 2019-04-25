package topico4.slide18.Ex2;

/**
 *
 * @author itsgnegrao
 */
public class T1 extends Thread {

    private static IntervalSyncronyzed interval;

    public T1(IntervalSyncronyzed interval, String name) {
        this.interval = interval;
        this.setName(name);
    }

    public static boolean isPrimo(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int number = this.interval.getNext();
                if (number < 0) {
                    this.stop();
                }
                else{
                    System.out.println("Thread " + this.getName() + " Peguei :" + String.valueOf(number));
                }
                if (isPrimo(number)) {
                    System.out.println("Thread " + this.getName() + " ," + String.valueOf(number) + " - É Primo!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
