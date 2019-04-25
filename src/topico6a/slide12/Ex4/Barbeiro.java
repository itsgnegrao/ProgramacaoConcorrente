package topico6a.slide12.Ex4;

/**
 *
 * @author itsgnegrao
 */
public class Barbeiro extends Thread {

    private static Barbearia barbearia;
    private static int tempoCorte;

    public Barbeiro(Barbearia barbearia ,int tempoCorte) {
        this.barbearia = barbearia;
        this.tempoCorte = tempoCorte;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                Cliente cliente = this.barbearia.cortar();

                if (cliente != null) {
                    System.out.println("\n[Barbeiro] - To cortando o cabelo do [" + cliente.getName() + "]");
                    cliente.stop();
                } else {
                    System.out.println("\n[Barbeiro] - Barbearia Vazia");
                }
                
                sleep(tempoCorte);
            } catch (Exception ex) {
            }
        }
    }
}
