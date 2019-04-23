package topico3.slide17;

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
            System.out.print("Digite a quantidade de Threads: ");
            String inputString = new Scanner(System.in).nextLine();
            List<T1> threads = new ArrayList<>();
            
            for(int i =0 ; i<Integer.valueOf(inputString); i++){
                T1 t = new T1("Thread "+i);
                t.start();
                threads.add(t);
            }
            
            while(true){
                System.out.println("");
                
                threads.forEach((thread) -> {
                    if(thread.isInterrupted()){
                       System.out.println("A "+thread.getName()+" Está Interrompida");
                       Thread.interrupted();
                    }
                });
                
                T1 thread = threads.get(new Random().nextInt(Integer.valueOf(inputString)));
                thread.interrupt();
                thread = threads.get(new Random().nextInt(Integer.valueOf(inputString)));
                thread.interrupt();
                
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
}
