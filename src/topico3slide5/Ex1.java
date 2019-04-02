package topico3slide5;

/**
 * Este exercício implemente uma Thread com a função Lambda
 */
public class Ex1 {
    public static void main(String[] args){
        new Thread(() -> System.out.println("Hello from thread!")).start();
    }
}
