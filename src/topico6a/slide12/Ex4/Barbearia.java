package topico6a.slide12.Ex4;

import java.util.ArrayList;

/**
 *
 * @author itsgnegrao
 */
public class Barbearia {

    private int qtdCadeiras = 0;
    private ArrayList<Cliente> cadeiras;

    public Barbearia(int qtdCadeiras) {
        this.qtdCadeiras = qtdCadeiras;
        this.cadeiras = new ArrayList<>(qtdCadeiras);
    }

    public synchronized Cliente cortar() {
        return (cadeiras.size() > 0 ? cadeiras.remove(0) : null);
    }

    public synchronized void sentar(Cliente cliente) throws InterruptedException {

        if (cadeiras.size() == qtdCadeiras) {
            return;
        }

        if (cadeiras.size() < qtdCadeiras) {
            if (!cadeiras.contains(cliente)) {
                System.out.println("[" + cliente.getName() + "] - Cheguei na barbearia!");
                System.out.println("[" + cliente.getName() + "] - Sentei na espera!");
                cadeiras.add(cliente);
                cliente.interrupt();

                System.out.println("\nFILA ______________________________");
                cadeiras.forEach((clienteSentado) -> {
                    System.out.println("[" + clienteSentado.getName() + "] - Esperando...");
                });
                System.out.println("___________________________________\n");
            }

        }
        wait();
    }

}
