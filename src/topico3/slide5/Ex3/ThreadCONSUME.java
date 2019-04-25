package topico3.slide5.Ex3;

/**
 *
 * @author itsgnegrao
 */
public class ThreadCONSUME extends Thread {

    ThreadPRODUCE productor;

    public ThreadCONSUME(ThreadPRODUCE productor) {
        this.productor = productor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(String.valueOf(Thread.currentThread().getName()
                        + ", Consumi o contador: " + String.valueOf(this.productor.getDisputedCounter())));
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
