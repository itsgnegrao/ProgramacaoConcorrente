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
        int qtdCadeiras = 10; //quantidade de cadeiras da barbearia
        int qtdClientes = 20; //quantidade de clientes máximo
        int tempoCorte = 1000; //tempo de corte maior que o tempo de chegada de cliente deixa fila cheia
        int tempoChegadaCliente = 200; // tempo de chegada maior que o tempo de corte deixa a fila vazia

        Barbearia barbearia = new Barbearia(qtdCadeiras);
        Barbeiro barbeiro = new Barbeiro(barbearia, tempoCorte);
        barbeiro.start();

        for (int i = 0; i < qtdClientes; i++) {
            Cliente cliente = new Cliente(barbearia);
            cliente.start();
            sleep(tempoChegadaCliente);
        }
        
        
    }

}
