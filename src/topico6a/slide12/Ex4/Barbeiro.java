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
                System.out.println("[Barbeiro] - Quem é o próximo??");
                Cliente cliente = this.barbearia.cortar();

                if (cliente != null) {
                    System.out.println("[Barbeiro] - To cortando o cabelo do [" + cliente.getName() + "]\n");
                    cliente.stop();
                } else {
                    System.out.println("[Barbeiro] - Barbearia Vazia\n");
                }
                
                sleep(tempoCorte);
                notifyAll();
                
            } catch (Exception ex) {
            }
        }
    }
}
