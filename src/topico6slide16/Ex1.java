package topico6slide16;

/**
 * Implemente o problema do produtor-consumidor que haa um
 * buffer compartilhado entre threads. Ha uma unica thread
 * produtora e uma unica consumidora. O buffer e preenchido
 * em tempos aleatorios pela thread produtora. Assim que for
 * produzido algo, a thread consumidora deve ser comunicada
 * para obter o valor.
 * 
 * @author itsgnegrao
 */
public class Ex1 {
    
    public static void main(String[] args) {
        Producer producer = new Producer(20);
        Consumer consumer = new Consumer(producer);
        producer.start();
        consumer.start();
    }
}
