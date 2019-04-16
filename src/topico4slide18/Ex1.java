package topico4slide18;

import java.util.*;
/**
 * Faca um programa em Java que use Threads para encontrar
 * os nuumeros primos dentro de um intervalo. O metodo que
 * contabiliza os numeros primos deve possuir como entrada:
 * valor inicial e final do intervalo, numero de threads.
 * @author itsgnegrao
 */

class T1 extends Thread{

    private static Interval interval;
    
    public T1(Interval interval, String name){
        this.interval = interval;
        this.setName(name);
    }

    public static boolean isPrimo (int x){
		for (int i=2; i<x; i++){
			if (x % i == 0){
                return false;
			}
		}
		return true;
	}

    @Override
    public void run(){
        while(true){
            try{
                int number = this.interval.getNext();
                if(number < 0) this.stop();
                if(isPrimo(number)) System.out.println("Thread "+this.getName()+" ,"+String.valueOf(number)+" - É Primo!");
            }
            catch(Exception e){
                e.printStackTrace();
            } 
        }
    }
}

class Interval {
    private int endInterval = 0;
    private int value = 0;

    public Interval(int startInterval, int endInterval){
        this.value = startInterval;
        this.endInterval = endInterval;
    }

    public int getNext(){
        int ret = value;
        value++;
        return (ret <= endInterval ? ret : -1);
    }
}

public class Ex1 {
    public static void main(String[] args){
        System.out.print("Digite um intervalo separados por espaço: ");
        String inputString[] = new Scanner(System.in).nextLine().split(" ");
        System.out.print("Digite a quantidade de Threads: ");
        String qtde = new Scanner(System.in).nextLine();
        
        Interval interval = new Interval(Integer.valueOf(inputString[0]), Integer.valueOf(inputString[1]));
        ArrayList<T1> threads = new ArrayList<>();
        
        try{
            System.out.println("Iniciando...");
            for (int i =0 ; i<Integer.valueOf(qtde); i++){
                threads.add(new T1(interval, String.valueOf(i)));
            }
            
            threads.forEach((thread) -> {
                thread.start();
            });
            
            System.out.println(qtde+" Threads Inicializadas...");

        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
}
