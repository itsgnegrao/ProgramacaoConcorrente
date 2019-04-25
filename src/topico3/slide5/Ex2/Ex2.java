package topico3.slide5.Ex2;

import java.util.*;

/**
 * Este exercício implementa uma thread utilizando duas diferentes abordagens
 * @author itsgnegrao
 */

class ThreadTP2 implements Runnable{
    @Override
    public void run(){
        System.out.println("Hello from thread tipo 2 "+String.valueOf(Thread.currentThread().getName())+"!");
    }
}

class ThreadTP1 extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from thread tipo 1 "+String.valueOf(Thread.currentThread().getName())+"!");
    }
}

public class Ex2 {
    public static void main(String[] args){
        System.out.print("Digite um número de Threads: ");
        String inputString = new Scanner( System.in).nextLine();
        List<Thread> threads;

        //primeiro teste
        threads = new ArrayList<Thread>();
        for (int i = 0; i<Integer.parseInt(inputString); i++){
            threads.add(new ThreadTP1());
        }
        for(Thread t: threads){
            t.start();
            try{t.sleep(200);}
            catch(Exception e){e.printStackTrace();}
        }

        //inicio do segundo teste
        threads = new ArrayList<Thread>();
        for (int i = 0; i<Integer.parseInt(inputString); i++){
            threads.add(new Thread(new ThreadTP2()));
        }
        for(Thread t: threads){
            t.start();
            try{t.sleep(200);}
            catch(Exception e){e.printStackTrace();}
        }
    }
}


