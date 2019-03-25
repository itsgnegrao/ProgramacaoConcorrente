package Aula1;

import java.util.*;

/**
 * Este exercício trata-se de um produtor/consumidor, onde uma thread é criada com a funcionalidade de incrementar um contador.
 * Outras Threads (quantidade informada pelo usuário) consomen este contador e tentam acessar o mesmo valor concorrentemente (forçando um erro)
 * @author itsgnegrao
 */

class ThreadCONSUME extends Thread{

    ThreadPRODUCE productor;

    public ThreadCONSUME(ThreadPRODUCE productor){
        this.productor = productor;
    }

    @Override
    public void run(){
        while(true){
            try{
                System.out.println(String.valueOf(Thread.currentThread().getName()+
                ", Consumi o contador: "+String.valueOf(this.productor.getDisputedCounter())));
                Thread.sleep(10);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class ThreadPRODUCE extends Thread{

    Integer disputedCounter = 0;

    public Integer getDisputedCounter() {
        return disputedCounter;
    }

    @Override
    public void run(){
        while(true){
            try{
                disputedCounter++;
                System.out.println("PRODUZI: "+String.valueOf(disputedCounter));
                this.sleep(1);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class Ex3 {
    public static void main(String[] args){
        System.out.print("Digite um número de Threads: ");
        String inputString = new Scanner( System.in).nextLine();
        List<Thread> threads;
        ThreadPRODUCE productor = new ThreadPRODUCE();
        
        //primeiro teste
        threads = new ArrayList<Thread>();
        for (int i = 0; i<Integer.parseInt(inputString); i++){
            threads.add(new ThreadCONSUME(productor));
        }
        for(Thread t: threads){t.start();}

        productor.start();        
    }
}


