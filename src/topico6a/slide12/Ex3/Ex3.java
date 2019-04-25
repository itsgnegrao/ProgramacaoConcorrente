package topico6a.slide12.Ex3;

/**
 * Escreva um monitor BoundedCounter que possui um valor
 * m´ınimo e m´aximo. A classe possui dois m´etodos: increment()
 * e decrement(). Ao alcan¸car os limites m´ınimo ou m´aximo, a
 * thread que alcan¸cou deve ser bloqueada.
 *
 * @author itsgnegrao
 */
public class Ex3 {

    public static void main(String[] args) {

        Monitor monitor = new Monitor(500, 1000);
        Process process1 = new Process(monitor,true,100);
        Process process2 = new Process(monitor,false,1);

        process1.start();
        process2.start();
        
    }

}
