package topico3.slide5.Ex1;

/**
 * Este exercício implemente uma Thread com a função Lambda
 * @author itsgnegrao
 */
public class Ex1 {
    public static void main(String[] args){
        new Thread(() -> System.out.println("Hello from thread!")).start();
    }
}
