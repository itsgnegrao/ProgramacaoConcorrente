package topico3.slide17;

import java.io.*;
import java.util.*;
/**
 * Faca uma Thread que monitora um conjunto de threads e
 * exiba quais threads receberam sinais de interrupcao.
 * @author itsgnegrao
 */

class T1 extends Thread{
    public T1(String name){
        this.setName(name);
    }

    @Override
    public void run(){
        while(true){
            try{}
            catch(Exception e){
                e.printStackTrace();
            } 
        }
    }
}


public class Ex4 {
    public static void main(String[] args){
        try{
            List<T1> threads = new ArrayList<>();
            for(int i =0 ; i<10; i++){
                T1 t = new T1("Thread "+i);
                t.start();
                threads.add(t);
            }
            while(true){
                System.out.println("");
                threads.stream().map((thread) -> {
                    if(thread.isInterrupted()){
                        System.out.println("A "+thread.getName()+" Está Interrompida");
                    }
                    return thread;
                }).forEachOrdered((thread) -> {
                    thread.interrupted();
                });
                T1 thread = threads.get(new Random().nextInt(9));
                thread.interrupt();
                thread = threads.get(new Random().nextInt(9));
                thread.interrupt();
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
}
