package topico6a.slide12.Ex4;

/**
 *
 * @author itsgnegrao
 */
public class Cliente extends Thread {

    private static Barbearia barbearia;

    public Cliente(Barbearia monitor) {
        this.barbearia = monitor;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                this.barbearia.sentar(this);
            } catch (InterruptedException ex) {
            }
        }
    }
}
