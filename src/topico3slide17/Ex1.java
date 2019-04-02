package topico3slide17;

import java.util.List;

/**
 * Faca um programa em Java que inicie tres threads e, cada
 * thread, espere um tempo aleatoorio para terminar.
 * @author itsgnegrao
 */
public class Ex1 {
    public static void main(String[] args){
        Thread t1, t2, t3;
        t1 = new Thread(() -> {
            System.out.println("Hello from thread 1!"); 
            try{Thread.sleep(4000);}catch(Exception e){} 
            System.out.println("Thread 1 Finalizada!");
        });
        t2 = new Thread(() -> {
            System.out.println("Hello from thread 2!"); 
            try{Thread.sleep(2000);} catch(Exception e){} 
            System.out.println("Thread 2 Finalizada!");
        });
        t3 = new Thread(() -> { 
            System.out.println("Hello from thread 3!"); 
            try{Thread.sleep(1000);} catch(Exception e){} 
            System.out.println("Thread 3 Finalizada!");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
