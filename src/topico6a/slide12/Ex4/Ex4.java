package topico6a.slide12.Ex4;

import static java.lang.Thread.sleep;

/**
 * Implemente uma solução para o problema do Barbeiro Dorminhoco usando
 * monitores.
 *
 * @author itsgnegrao
 */
public class Ex4 {

    public static void main(String[] args) throws InterruptedException {

        //variaveis modificadoras
        int qtdCadeiras = 10;
        int qtdClientes = 30;
        int tempoCorte = 1000;
        int tempoChegadaCliente = 200;

        Barbearia barbearia = new Barbearia(qtdCadeiras);
        Barbeiro barbeiro = new Barbeiro(barbearia, tempoCorte);
        barbeiro.start();

        for (int i = 0; i < qtdClientes; i++) {
            Cliente cliente = new Cliente(barbearia);
            cliente.start();
            System.out.println("Cliente ["+cliente.getName()+"] criado..\n");
            sleep(tempoChegadaCliente);
        }
        
    }

}
