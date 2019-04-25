package topico3.slide17.Ex4;

/**
 *
 * @author itsgnegrao
 */
public class T extends Thread {

    public T(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
