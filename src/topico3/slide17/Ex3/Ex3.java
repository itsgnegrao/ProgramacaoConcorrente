package topico3.slide17.Ex3;

/**
 * Faca um programa Java que envia interru¸coes para as threads dos exercicios
 * anteriores. As threads devem fazer o tratamento dessas interrupcoes e
 * realizar uma finalizacao limpa.
 *
 * @author itsgnegrao
 */

public class Ex3 {

    public static void main(String[] args) {
        try {
            Thread t1 = new T();
            t1.start();
            Thread.sleep(5000);
            t1.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
