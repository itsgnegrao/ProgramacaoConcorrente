package topico6a.slide12.Ex1;

/**
 * Implemente uma solu¸c˜ao com monitor para o problema do Produtor-Consumidor
 * usando um buffer circular. ARRAY infinito = buffer circular (ARRAY!)
 *
 * utilizar mod (%) para achar posição no array
 *
 * @author itsgnegrao
 */
public class Ex1 {

    private static int sizeBuffer = 100;

    public static void main(String[] args) {

        Monitor monitor = new Monitor(sizeBuffer);
        Producer producer = new Producer(monitor);
        Consumer consumer = new Consumer(monitor);
//        Consumer consumer2 = new Consumer(monitor);

        producer.start();
        consumer.start();
//        consumer2.start();
    }
}
