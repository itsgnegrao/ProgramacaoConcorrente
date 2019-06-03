package topico9.slide15.Ex1;

/**
 *
 * @author itsgnegrao
 */
public class Ex1 {

    private static int qtdThreads = 2;

    public static void main(String[] args) {
        Counter c = new Counter();

        for (int i = 0; i < qtdThreads; i++) {
            new Acess((i % 2 == 0), c).start();
//            new Acess(true, c).start();
        }

    }

}
