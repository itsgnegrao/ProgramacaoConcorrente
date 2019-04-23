package topico6a.slide12.Ex2;

/**
 * Escreva uma monitor Counter que possibilita um processo dormir at´e o
 * contador alcan¸car um valor. A classe Counter permite duas opera¸c˜oes:
 * increment() e sleepUntil(int x).
 *
 * @author itsgnegrao
 */
public class Ex2 {

    public static void main(String[] args) {

        Monitor monitor = new Monitor();
        Process process = new Process();

        process.start();
        
        while (true) {
            monitor.sleepUntil(1000L, process);
            while(monitor.increment()){
                Thread.yield();
            }
        }
        
    }

}
